import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './AceEditor.soy';

/**
 * @param  {...any} args
 */
const FragmentAutocompleteProcessor = function(...args) {
	FragmentAutocompleteProcessor.superclass.constructor.apply(this, args);
};

/**
 * This Component creates an instance of Ace editor
 * to allow code editing.
 */
class AceEditor extends Component {

	/**
	 * @inheritDoc
	 */
	attached() {
		this._editorDocument = null;
		this._getAutocompleteSuggestion = this._getAutocompleteSuggestion.bind(this);
		this._handleDocumentChanged = this._handleDocumentChanged.bind(this);

		AUI().use(
			'aui-ace-editor',
			'aui-ace-autocomplete-plugin',
			'aui-ace-autocomplete-templateprocessor',

			A => {
				const editor = new A.AceEditor(
					{
						boundingBox: this.refs.wrapper,
						highlightActiveLine: false,
						mode: this.syntax,
						tabSize: 2
					}
				);

				this._overrideSetAnnotations(editor.getSession());
				this._editorSession = editor.getSession();
				this._editorDocument = editor.getSession().getDocument();

				this.refs.wrapper.style.height = '';
				this.refs.wrapper.style.width = '';

				this._editorDocument.on('change', this._handleDocumentChanged);

				editor.getSession().on('changeAnnotation', this._handleDocumentChanged);

				if (this.initialContent) {
					this._editorDocument.setValue(this.initialContent);
				}

				this._initAutocomplete(A, editor);
			}
		);
	}

	/**
	 * @inheritDoc
	 */
	shouldUpdate() {
		return false;
	}

	/**
	 * @param {object} A
	 * @param {object} editor
	 * @private
	 * @review
	 */
	_initAutocomplete(A, editor) {
		if (this.syntax !== 'html') {
			return;
		}

		A.extend(
			FragmentAutocompleteProcessor,
			A.AceEditor.TemplateProcessor,

			{
				getMatch: this._getAutocompleteMatch,
				getSuggestion: this._getAutocompleteSuggestion
			}
		);

		const autocompleteProcessor = new FragmentAutocompleteProcessor(
			{
				directives: this.autocompleteTags.map(tag => tag.name)
			}
		);

		editor.plug(
			A.Plugin.AceAutoComplete,
			{
				processor: autocompleteProcessor,
				render: true,
				visible: false,
				zIndex: 10000
			}
		);
	}

	/**
	 * This method returns a match object (if any) for "lfr-" tags
	 * inside the given content.
	 * @param {string} content
	 * @private
	 * @return {object} Match result
	 */
	_getAutocompleteMatch(content) {
		let match = null;
		let matchContent = content;
		let matchIndex = null;

		if (matchContent.lastIndexOf('<') >= 0) {
			matchIndex = matchContent.lastIndexOf('<');

			matchContent = matchContent.substring(matchIndex);

			if (/<lfr[\w]*[^<lfr]*$/.test(matchContent)) {
				match = {
					content: matchContent.substring(1),
					start: matchIndex,
					type: 0
				};
			}
		}

		return match;
	}

	/**
	 * This method returns a tag completion suggestion for the given
	 * match and selectedSuggestion.
	 * @param {object} match
	 * @param {string} selectedSuggestion
	 * @private
	 * @return {string}
	 */
	_getAutocompleteSuggestion(match, selectedSuggestion) {
		const tag = this.autocompleteTags.find(
			_tag => _tag.name === selectedSuggestion
		);

		return tag ? tag.content.substring(1) : '';
	}

	/**
	 * This Callback is executed when the internal Ace editor has been
	 * modified. It simply propagates the event.
	 * @private
	 */
	_handleDocumentChanged() {
		const valid = this._editorSession.getAnnotations().reduce(
			(acc, annotation) => {
				return (!acc || (annotation.type === 'error')) ?
					false :
					acc;
			},
			true
		);

		this.emit(
			'contentChanged',
			{
				content: this._editorDocument.getValue(),
				valid
			}
		);
	}

	/**
	 * This overrides the AceEditor's session setAnnotations method to avoid 
	 * showing misleading messages.
	 * @param {Object} session AceEditor session
	 * @private
	 */
	_overrideSetAnnotations(session) {
		const setAnnotations = session.setAnnotations.bind(session);

		session.setAnnotations = annotations => {
			setAnnotations(
				annotations.filter(annotation => annotation.type !== 'info')
			);
		};
	}

}

/**
 * Defines the available AceEditor syntax.
 * @static
 * @type {Object}
 */

AceEditor.SYNTAX = {
	css: 'css',
	html: 'html',
	javascript: 'javascript'
};

/**
 * State definition.
 * @static
 * @type {!Object}
 */

AceEditor.STATE = {

	/**
	 * Provide the list of tags for custom autocomplete in the HTML editor.
	 * @default []
	 * @instance
	 * @memberOf AceEditor
	 * @type Array
	 */

	autocompleteTags: Config.arrayOf(
		Config.shapeOf(
			{
				attributes: Config.arrayOf(Config.string()),
				name: Config.string()
			}
		)
	),

	/**
	 * Defines the initial content sent to the editor.
	 * @default ''
	 * @instance
	 * @memberOf AceEditor
	 * @type {string}
	 */

	initialContent: Config.string().value(''),

	/**
	 * Syntax used for the Ace Editor that is rendered on the interface.
	 * @default undefined
	 * @instance
	 * @memberOf AceEditor
	 * @see AceEditor.SYNTAX
	 * @type {!string}
	 */

	syntax: Config.oneOf(Object.values(AceEditor.SYNTAX)).required()
};

Soy.register(AceEditor, templates);

export {AceEditor};
export default AceEditor;