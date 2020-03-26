require.config({
    baseUrl: conf.getStaticServerUrl() + "/resources/scripts/test",
    urlArgs: "v=" + conf.getVersion()+"_1",
    waitSeconds: 0,
    paths: {
        stylesheets: conf.getStaticServerUrl() + "/resources/stylesheets",
        plugin: conf.getStaticServerUrl() + "/resources/scripts/plugins",
        dhtmlx: conf.getStaticServerUrl() + "/resources/scripts/dhtmlx",
        codeMirror: conf.getStaticServerUrl() + "/resources/scripts/plugins/codeMirror",
        aceEditor: conf.getStaticServerUrl() + "/resources/scripts/plugins/aceEditor"
    },
    shim: {
        "dhtmlx/tree/dhtmlxtree": { deps: ["dhtmlx/tree/dhtmlxcommon"] },
        "dhtmlx/tree/ext/dhtmlxtree_ed": { deps: ["dhtmlx/tree/dhtmlxtree"] },
        "dhtmlx/tree/ext/dhtmlxtree_kn": { deps: ["dhtmlx/tree/dhtmlxtree"] },
        "dhtmlx/tree/ext/dhtmlxtree_json": { deps: ["dhtmlx/tree/dhtmlxtree"] },
        "dhtmlx/menu/dhtmlxmenu": { deps: ["dhtmlx/tree/dhtmlxcommon"] },
        "dhtmlx/menu/ext/dhtmlxmenu_ext": { deps: ["dhtmlx/menu/dhtmlxmenu"] },
        "dhtmlx/layout/dhtmlxcontainer": { deps: ["dhtmlx/layout/dhtmlxcommon"] },
        "dhtmlx/tabbar/dhtmlxtabbar": { deps: ["dhtmlx/tree/dhtmlxcommon"] },
        "dhtmlx/windows/dhtmlxwindows": { deps: ["dhtmlx/tree/dhtmlxcommon"] },
        "dhtmlx/layout/dhtmlxlayout": { deps: ["dhtmlx/layout/dhtmlxcontainer"] },
        "plugin/jquery/oscZenoedited": { deps: ["css!stylesheets/jquery/oscZenoedited.css"] },
        "plugin/jquery/CalcSS3": { deps: ["css!stylesheets/jquery/CalcSS3.css"] },
        "plugin/ckeditor/adapters/jquery" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/config" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/skins/bootstrapck/skin" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/lang/en-gb" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/styles" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/indentblock/plugin" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/font/plugin" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/autogrow/plugin" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/divarea/plugin" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/font/lang/en-gb" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/specialchar/dialogs/lang/en" : { deps : ["plugin/ckeditor/ckeditor"]},
        "plugin/ckeditor/plugins/specialchar/dialogs/specialchar" : { deps : ["plugin/ckeditor/ckeditor"]},
        "directives/diagramDirective": { deps : [
            "css!plugin/mxGraph/styles/grapheditor",
            "css!plugin/mxGraph/styles/common",
            "css!plugin/mxGraph/styles/explorer",
            "plugin/mxGraph/js/mxGraphTools.min",
            "plugin/mxGraph/sanitizer/sanitizer.min",
            "plugin/mxGraph/js/mxClient.min",
            "plugin/mxGraph/util/utils.min",
            "plugin/mxGraph/shape/shape.min",
            "plugin/mxGraph/layout/layout.min",
            "plugin/mxGraph/model/model.min",
            "plugin/mxGraph/view/view.min",
            "plugin/mxGraph/handler/handler.min",
            "plugin/mxGraph/editor/editor.min",
            "plugin/mxGraph/io/io.min"
        ]},
        "directives/diagramDirective.min": { deps : [
            "css!plugin/mxGraph/styles/grapheditor",
            "css!plugin/mxGraph/styles/common",
            "css!plugin/mxGraph/styles/explorer",
            "plugin/mxGraph/js/mxGraphTools.min",
            "plugin/mxGraph/sanitizer/sanitizer.min",
            "plugin/mxGraph/js/mxClient.min",
            "plugin/mxGraph/util/utils.min",
            "plugin/mxGraph/shape/shape.min",
            "plugin/mxGraph/layout/layout.min",
            "plugin/mxGraph/model/model.min",
            "plugin/mxGraph/view/view.min",
            "plugin/mxGraph/handler/handler.min",
            "plugin/mxGraph/editor/editor.min",
            "plugin/mxGraph/io/io.min"
        ]},
        "plugin/mxGraph/shape/shape.min" : {deps: ["plugin/mxGraph/util/utils.min"]},
        "plugin/mxGraph/util/utils.min":{deps: ["plugin/mxGraph/js/mxClient.min"]},
        "plugin/mxGraph/editor/editor.min" : {deps :["plugin/mxGraph/util/utils.min"]},
        "plugin/mxGraph/io/io.min" : {deps :["plugin/mxGraph/model/model.min", "plugin/mxGraph/view/view.min"]},
        "plugin/mxGraph/model/model.min" : {deps :["plugin/mxGraph/util/utils.min"]},
        "plugin/mxGraph/layout/layout.min" : {deps :["plugin/mxGraph/util/utils.min"]},
        "plugin/mxGraph/handler/handler.min" : {deps :["plugin/mxGraph/util/utils.min"]},
        "plugin/mxGraph/view/view.min" : {deps :["plugin/mxGraph/util/utils.min","plugin/mxGraph/shape/shape.min"]},

        "plugin/mxGraph/js/mxGraphTools.min": {deps: ["plugin/mxGraph/js/mxClient.min","plugin/mxGraph/util/utils.min", "plugin/mxGraph/view/view.min","plugin/mxGraph/model/model.min"]},

        "controllers/diagramQuestionCtrl" : { deps : [ "directives/diagramDirective" ] },
        "controllers/diagramQuestionCtrl.min" : { deps : [ "directives/diagramDirective.min" ] },

        "directives/longAnswerDirective": { deps : [
            "plugin/ckeditor/adapters/jquery",
            "plugin/ckeditor/config",
            "plugin/ckeditor/skins/bootstrapck/skin",
            "plugin/ckeditor/lang/en-gb",
            "plugin/ckeditor/styles",
            "plugin/ckeditor/plugins/indentblock/plugin",
            "plugin/ckeditor/plugins/font/plugin",
            "plugin/ckeditor/plugins/autogrow/plugin",
            "plugin/ckeditor/plugins/divarea/plugin",
            "plugin/ckeditor/plugins/font/lang/en-gb",
            "plugin/ckeditor/plugins/specialchar/dialogs/lang/en",
            "plugin/ckeditor/plugins/specialchar/dialogs/specialchar",
            "css!plugin/ckeditor/skins/bootstrapck/editor",
            "css!plugin/ckeditor/skins/bootstrapck/dialog"
        ]},
        "directives/longAnswerDirective.min": { deps : [
            "plugin/ckeditor/adapters/jquery",
            "plugin/ckeditor/config",
            "plugin/ckeditor/config",
            "plugin/ckeditor/skins/bootstrapck/skin",
            "plugin/ckeditor/lang/en-gb",
            "plugin/ckeditor/styles",
            "plugin/ckeditor/plugins/indentblock/plugin",
            "plugin/ckeditor/plugins/font/plugin",
            "plugin/ckeditor/plugins/autogrow/plugin",
            "plugin/ckeditor/plugins/divarea/plugin",
            "plugin/ckeditor/plugins/font/lang/en-gb",
            "plugin/ckeditor/plugins/specialchar/dialogs/lang/en",
            "plugin/ckeditor/plugins/specialchar/dialogs/specialchar",
            "css!plugin/ckeditor/skins/bootstrapck/editor",
            "css!plugin/ckeditor/skins/bootstrapck/dialog"
        ]},
        "plugin/jquery/jquery.pplayer" : { deps : [ "css!stylesheets/plugins/pplayer/pplayer"]},
        "directives/codeEditorDirective": { deps : [
            "css!codeMirror/lib/codemirror",
            "css!codeMirror/lib/robotoMono",
            "codeMirror/addon/search/searchcursor",
            "codeMirror/mode/clike/clike",
            "codeMirror/mode/htmlembedded/htmlembedded",
            "codeMirror/mode/htmlmixed/htmlmixed",
            "codeMirror/mode/php/php",
            "codeMirror/mode/python/python",
            "codeMirror/mode/ruby/ruby",
            "codeMirror/mode/vb/vb",
            "codeMirror/mode/xml/xml",
            "codeMirror/mode/sql/sql",
            "codeMirror/mode/swift/swift",
            "codeMirror/mode/go/go",
            "codeMirror/mode/javascript/javascript",
            "codeMirror/mode/r/r",
            "codeMirror/mode/elixir/elixir"
        ]},
        "directives/codeEditorDirective.min": { deps : [
            "css!codeMirror/lib/codemirror",
            "css!codeMirror/lib/robotoMono",
            "codeMirror/addon/search/searchcursor",
            "codeMirror/mode/clike/clike",
            "codeMirror/mode/htmlembedded/htmlembedded",
            "codeMirror/mode/htmlmixed/htmlmixed",
            "codeMirror/mode/php/php",
            "codeMirror/mode/python/python",
            "codeMirror/mode/ruby/ruby",
            "codeMirror/mode/vb/vb",
            "codeMirror/mode/xml/xml",
            "codeMirror/mode/sql/sql",
            "codeMirror/mode/swift/swift",
            "codeMirror/mode/go/go",
            "codeMirror/mode/javascript/javascript",
            "codeMirror/mode/r/r",
            "codeMirror/mode/elixir/elixir"
        ]},
        "directives/monacoEditorDirective": {
            deps: [
                "plugin/common-plugins/monaco-mettl.min",
                "css!plugin/monaco-editor/monaco-editor-styling",
                "plugin/common-plugins/lsp-metric-sender.min"
            ]
        },
        "directives/monacoEditorDirective.min": {
            deps: [
                "plugin/common-plugins/monaco-mettl.min",
                "css!plugin/monaco-editor/monaco-editor-styling",
                "plugin/common-plugins/lsp-metric-sender.min"
            ]
        },
        "controllers/longAnswerQuestionCtrl" : { deps : [ "directives/longAnswerDirective" ] },
        "controllers/longAnswerQuestionCtrl.min" : { deps : [ "directives/longAnswerDirective.min" ] },
        "controllers/fileUploadQuestionCtrl" : { deps : ["plugin/jquery/jQuery-File-Upload/js/jquery.fileupload"] },
        "plugin/jquery/jQuery-File-Upload/js/jquery.fileupload": {deps:["plugin/jquery/jQuery-File-Upload/js/vendor/jquery.ui.widget",
                        "plugin/jquery/jQuery-File-Upload/js/jquery.iframe-transport"
                    ]},
        "controllers/fileUploadQuestionCtrl.min" : { deps : ["plugin/jquery/jQuery-File-Upload/js/jquery.fileupload.min"] },
        "plugin/jquery/jQuery-File-Upload/js/jquery.fileupload.min": {deps:["plugin/jquery/jQuery-File-Upload/js/jquery.ui.widget.min",
                        "plugin/jquery/jQuery-File-Upload/js/jquery.iframe-transport.min"
        ]},
        "controllers/casestudyQuestionCtrl" : { deps : [
                "css!stylesheets/dhtmlx/tree/dhtmlxtree",
                "css!stylesheets/dhtmlx/grid/dhtmlxgrid_dhx_skyblue",
                "dhtmlx/tree/ext/dhtmlxtree_ed",
                "dhtmlx/tree/ext/dhtmlxtree_kn",
                "dhtmlx/tree/ext/dhtmlxtree_json"
            ]  },
        "controllers/casestudyQuestionCtrl.min" : { deps : [
            "css!stylesheets/dhtmlx/tree/dhtmlxtree",
            "css!stylesheets/dhtmlx/grid/dhtmlxgrid_dhx_skyblue",
            "dhtmlx/tree/ext/dhtmlxtree_ed",
            "dhtmlx/tree/ext/dhtmlxtree_kn",
            "dhtmlx/tree/ext/dhtmlxtree_json"
        ]  },
        "controllers/codeProjectQuestionCtrl" : { deps : [
                "css!stylesheets/dhtmlx/layout/dhtmlxlayout",
                "css!stylesheets/dhtmlx/layout/skins/dhtmlxlayout_dhx_web",
                "css!stylesheets/dhtmlx/tree/dhtmlxtree",
                "css!stylesheets/dhtmlx/menu/skins/dhtmlxmenu_dhx_skyblue",
                "css!stylesheets/dhtmlx/tabbar/dhtmlxtabbar",
                "css!stylesheets/dhtmlx/windows/dhtmlxwindows",
                "css!stylesheets/dhtmlx/windows/skins/dhtmlxwindows_dhx_skyblue",
                "css!stylesheets/jquery/jquery-ui-1.8.16.autocomplete",
                "css!codeMirror/lib/codemirror",
                "css!codeMirror/addon/hint/show-hint",
                "css!codeMirror/addon/lint/lint",
                "css!codeMirror/addon/fold/foldgutter",
                "css!codeMirror/addon/display/fullscreen",
                "css!codeMirror/lib/robotoMono",
                "dhtmlx/layout/dhtmlxcontainer",
                "dhtmlx/layout/dhtmlxlayout",
                "dhtmlx/tree/ext/dhtmlxtree_json",
                "dhtmlx/tree/ext/dhtmlxtree_ed",
                "dhtmlx/tree/ext/dhtmlxtree_kn",
                "dhtmlx/menu/dhtmlxmenu",
                "dhtmlx/menu/ext/dhtmlxmenu_ext",
                "dhtmlx/tabbar/dhtmlxtabbar",
                "dhtmlx/windows/dhtmlxwindows",
                "codeMirror/addon/display/fullscreen",
                "codeMirror/addon/selection/active-line",
                "codeMirror/addon/hint/show-hint",
                "codeMirror/addon/hint/mettl-hint",
                "codeMirror/addon/fold/brace-fold",
                "codeMirror/addon/fold/indent-fold",
                "codeMirror/addon/fold/markdown-fold",
                "codeMirror/addon/fold/xml-fold",
                "codeMirror/addon/fold/comment-fold",
                "codeMirror/addon/fold/foldcode",
                "codeMirror/addon/fold/foldgutter",
                "codeMirror/addon/lint/lint",
                "codeMirror/addon/edit/closebrackets",
                "codeMirror/addon/edit/trailingspace",
                "codeMirror/addon/edit/closetag",
                "codeMirror/addon/edit/continuelist",
                "codeMirror/addon/edit/matchbrackets",
                "codeMirror/addon/edit/matchtags",
                "codeMirror/mode/clike/clike",
                "codeMirror/mode/htmlembedded/htmlembedded",
                "codeMirror/mode/htmlmixed/htmlmixed",
                "codeMirror/mode/javascript/javascript",
                "codeMirror/mode/sql/sql",
                "codeMirror/mode/xml/xml",
                "codeMirror/intellisense-client",
                "plugin/jquery/jquery-ui-1.9.2.custom.min",
                "plugin/jquery/jqueryui.draggable-resizable",
                "test-window/codeProject"
            ]
        },
        "controllers/codeProjectQuestionCtrl.min": {
            deps: [
                "css!stylesheets/dhtmlx/layout/dhtmlxlayout",
                "css!stylesheets/dhtmlx/layout/skins/dhtmlxlayout_dhx_web",
                "css!stylesheets/dhtmlx/tree/dhtmlxtree",
                "css!stylesheets/dhtmlx/menu/skins/dhtmlxmenu_dhx_skyblue",
                "css!stylesheets/dhtmlx/tabbar/dhtmlxtabbar",
                "css!stylesheets/dhtmlx/windows/dhtmlxwindows",
                "css!stylesheets/dhtmlx/windows/skins/dhtmlxwindows_dhx_skyblue",
                "css!stylesheets/jquery/jquery-ui-1.8.16.autocomplete",
                "css!codeMirror/lib/codemirror",
                "css!codeMirror/addon/hint/show-hint",
                "css!codeMirror/addon/lint/lint",
                "css!codeMirror/addon/fold/foldgutter",
                "css!codeMirror/addon/display/fullscreen",
                "css!codeMirror/lib/robotoMono",
                "dhtmlx/layout/dhtmlxcontainer",
                "dhtmlx/layout/dhtmlxlayout",
                "dhtmlx/tree/ext/dhtmlxtree_json",
                "dhtmlx/tree/ext/dhtmlxtree_ed",
                "dhtmlx/tree/ext/dhtmlxtree_kn",
                "dhtmlx/menu/dhtmlxmenu",
                "dhtmlx/menu/ext/dhtmlxmenu_ext",
                "dhtmlx/tabbar/dhtmlxtabbar",
                "dhtmlx/windows/dhtmlxwindows",
                "codeMirror/addon/display/fullscreen",
                "codeMirror/addon/selection/active-line",
                "codeMirror/addon/hint/show-hint",
                "codeMirror/addon/hint/mettl-hint",
                "codeMirror/addon/fold/brace-fold",
                "codeMirror/addon/fold/indent-fold",
                "codeMirror/addon/fold/markdown-fold",
                "codeMirror/addon/fold/xml-fold",
                "codeMirror/addon/fold/comment-fold",
                "codeMirror/addon/fold/foldgutter",
                "codeMirror/addon/fold/foldcode",
                "codeMirror/addon/lint/lint",
                "codeMirror/addon/edit/closebrackets",
                "codeMirror/addon/edit/trailingspace",
                "codeMirror/addon/edit/closetag",
                "codeMirror/addon/edit/continuelist",
                "codeMirror/addon/edit/matchbrackets",
                "codeMirror/addon/edit/matchtags",
                "codeMirror/mode/clike/clike",
                "codeMirror/mode/htmlembedded/htmlembedded",
                "codeMirror/mode/htmlmixed/htmlmixed",
                "codeMirror/mode/javascript/javascript",
                "codeMirror/mode/sql/sql",
                "codeMirror/mode/xml/xml",
                "codeMirror/intellisense-client",
                "plugin/jquery/jquery-ui-1.9.2.custom.min",
                "plugin/jquery/jqueryui.draggable-resizable",
                "test-window/codeProject.min"
            ]
        },
        "controllers/fesQuestionCtrl": {
            deps: [
                "css!stylesheets/plugins/fes",
                "css!stylesheets/jquery/jquery-ui-1.8.14.custom",
                "css!codeMirror/lib/codemirror",
                "css!codeMirror/addon/hint/show-hint",
                "css!codeMirror/addon/fold/foldgutter",
                "css!codeMirror/addon/lint/lint",
                "css!codeMirror/lib/robotoMono",
                "codeMirror/addon/hint/show-hint",
                "codeMirror/addon/fold/brace-fold",
                "codeMirror/addon/fold/indent-fold",
                "codeMirror/addon/fold/markdown-fold",
                "codeMirror/addon/fold/foldcode",
                "codeMirror/addon/fold/comment-fold",
                "codeMirror/addon/lint/lint",
                "codeMirror/addon/hint/html-hint",
                "codeMirror/addon/hint/javascript-hint",
                "codeMirror/mode/jsx/jsx",
                "codeMirror/addon/hint/xml-hint",
                "codeMirror/addon/lint/javascript-lint",
                "codeMirror/addon/lint/css-lint",
                "codeMirror/addon/hint/fes-hint.min",
                "codeMirror/addon/edit/matchbrackets",
                "codeMirror/addon/edit/matchtags",
                "codeMirror/mode/css/css",
                "plugin/jquery/jqueryui.draggable-resizable",
                "plugin/fes/fes"

            ] },
        "controllers/fesQuestionCtrl.min" : { deps : [
            "css!stylesheets/plugins/fes",
            "css!stylesheets/jquery/jquery-ui-1.8.14.custom",
            "css!codeMirror/lib/codemirror",
            "css!codeMirror/addon/hint/show-hint",
            "css!codeMirror/addon/fold/foldgutter",
            "css!codeMirror/addon/lint/lint",
            "css!codeMirror/lib/robotoMono",
            "codeMirror/addon/hint/show-hint",
            "codeMirror/addon/fold/brace-fold",
            "codeMirror/addon/fold/indent-fold",
            "codeMirror/addon/fold/markdown-fold",
            "codeMirror/addon/fold/foldcode",
            "codeMirror/addon/fold/comment-fold",
            "codeMirror/addon/lint/lint",
            "codeMirror/addon/hint/html-hint",
            "codeMirror/addon/hint/javascript-hint",
            "codeMirror/mode/jsx/jsx",
            "codeMirror/addon/hint/xml-hint",
            "codeMirror/addon/lint/javascript-lint",
            "codeMirror/addon/lint/css-lint",
            "codeMirror/addon/hint/fes-hint.min",
            "codeMirror/addon/edit/matchbrackets",
            "codeMirror/addon/edit/matchtags",
            "plugin/jquery/jqueryui.draggable-resizable",
            "plugin/fes/fes"
        ] },
        "controllers/dbQuestionCtrl" : { deps : [
                "css!codeMirror/lib/codemirror",
                "css!codeMirror/lib/robotoMono",
                "codeMirror/lib/codemirror"
            ] },
        "controllers/dbQuestionCtrl.min" : { deps : [
            "css!codeMirror/lib/codemirror",
            "css!codeMirror/lib/robotoMono",
            "codeMirror/lib/codemirror"
        ] },
        "controllers/codeQuestionCtrl" : { deps : [
            "css!plugin/bootstrap-tour-style",
            "plugin/bootstrap-tour"
        ]},
        "controllers/codeQuestionCtrl.min" : { deps : [
            "css!plugin/bootstrap-tour-style",
            "plugin/bootstrap-tour"
        ]},
        "controllers/rQuestionCtrl": { deps:[
            "plugin/aceEditor/ace",
            "plugin/aceEditor/mode-r",
            "plugin/aceEditor/range",
            "plugin/aceEditor/theme-solarized_dark",
            "plugin/mettl.socket.min",
            "plugin/rLanguage/rLanguage.min"
         ]
        },
        "controllers/rQuestionCtrl.min": { deps:[
	        "plugin/aceEditor/ace",
	        "plugin/aceEditor/mode-r",
	        "plugin/aceEditor/range",
	        "plugin/aceEditor/theme-solarized_dark",
	        "plugin/mettl.socket.min",
            "plugin/rLanguage/rLanguage.min"
	     ]
        },
        "controllers/meanQuestionCtrl": { deps: [
            "plugin/mettl.socket.min",
            "plugin/meanStack/meanStack.min"
            ]
        },
        "controllers/meanQuestionCtrl.min": { deps: [
            "plugin/mettl.socket.min",
            "plugin/meanStack/meanStack.min"
            ]
        },
        "controllers/mediaQuestionCtrl": { deps: [
            "plugin/kurento/adapter",
            "plugin/recordRTC.min"
        ]},
        "controllers/mediaQuestionCtrl.min": { deps: [
            "plugin/kurento/adapter.min",
            "plugin/recordRTC.min"
        ]},
        "controllers/diagnosticsMediaQuestionCtrl": { deps : [
            "plugin/kurento/adapter",
            "plugin/recordRTC.min",
            "plugin/common-plugins/carnegie/audioFileReader"
        ]},
        "controllers/diagnosticsMediaQuestionCtrl.min": { deps : [
            "plugin/kurento/adapter.min",
            "plugin/recordRTC.min",
            "plugin/common-plugins/carnegie/audioFileReader.min"
        ]},
        "services/proctoring/proctoringFactory": {
            deps: [
          "plugin/kurento/adapter",
          "plugin/kurento/kurento-utils"
            ]
        },
        "services/proctoring/proctoringFactory.min": {
            deps: [
          "plugin/kurento/adapter.min",
          "plugin/kurento/kurento-utils.min"
            ]
        }
    },
    map: {
        '*': {
            'css': conf.getStaticServerUrl() + "/resources/scripts/plugins/require/require-css.min.js"
        }
    }
});

var isImageProctored = conf.isImageProctored() == "true";
var isMediaTypeQuestion = conf.isMediaTypeQuestion() == "true";
var proctoringServerBaseUrl = conf.getProctoringStaticUrl() + "/scripts/";

if (isImageProctored) {
    require([proctoringServerBaseUrl + "webRTCProvider.min.js"], function (){
        webRTCProvider.loadFiles(function () {
            require([proctoringServerBaseUrl + "mettlProctoringProvider.min.js"], function () {
                proctoringProvider.loadFiles(function () {
                    loadApp();
                });
            });
        });
    });
} else if(isMediaTypeQuestion) {
    require([proctoringServerBaseUrl + "webRTCProvider.min.js"], function () {
            webRTCProvider.loadFiles(function () {
                loadApp();
           });
        });
} else {
    loadApp();
}

function loadApp() {
    require(["app", "../plugins/require/require-css.min"],
        function () {
            angular.bootstrap(document, ["mettl"]);
        }
    );
}
