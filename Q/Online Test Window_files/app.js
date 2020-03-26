define2([], function () {

    var modules = ['ui.router', 'ngSanitize','ngTouch'];

    if(typeof mettlProctor == "object"){
        modules.push('mettlProctor');
    }

    if(typeof webRTC == "object"){
        modules.push('webRTC');
    }

    var mettl = angular.module('mettl', modules);

    mettl.config(['$stateProvider', '$urlRouterProvider', '$controllerProvider', '$compileProvider', '$filterProvider', '$provide', '$httpProvider',
        function ($stateProvider, $urlRouterProvider, $controllerProvider, $compileProvider, $filterProvider, $provide, $httpProvider) {


            mettl.register = {
                controller: $controllerProvider.register,
                directive: $compileProvider.directive,
                filter: $filterProvider.register,
                factory: $provide.factory,
                constant: $provide.constant,
                service: $provide.service
            };

            //$httpProvider.interceptors.push('httpInterceptor');

            function controllerResolver(controllerName) {
                return {
                    'getter': function ($q) {
                        var deferred = $q.defer();
                        require2(["controllers/" + controllerName + "Ctrl"], function () {
                            deferred.resolve();
                        });
                        return deferred.promise;
                    }
                };
            }

            function questionControllerResolver() {
                var map = {
                    1: {controller: "mcqQuestion", templateUrl: '/partials/rr_mcqa'},
                    2: {controller: "codeQuestion", templateUrl: '/partials/rr_code'},
                    3: {controller: "fitbQuestion", templateUrl: '/partials/rr_fitb'},
                    4: {controller: "longAnswerQuestion", templateUrl: '/partials/rr_long_answer'},
                    5: {controller: "mcaQuestion", templateUrl: '/partials/rr_mcqa'},
                    6: {controller: "dbQuestion", templateUrl: '/partials/rr_db'},
                    7: {controller: "shortAnswerQuestion", templateUrl: '/partials/rr_short_answer'},
                    8: {controller: "casestudyQuestion", templateUrl: '/partials/rr_cs'},
                    9: {controller: "codeProjectQuestion", templateUrl: '/partials/rr_cp'},
                    10: {controller: "spreadsheetQuestion", templateUrl: '/partials/rr_ss'},
                    13: {controller: "fesQuestion", templateUrl: '/partials/rr_fes'},
                    14: {controller: "typingQuestion", templateUrl: '/partials/rr_typing'},
                    15: {controller:"fileUploadQuestion" , templateUrl:'/partials/rr_fu'},
                    16: {controller: "msqQuestion", templateUrl:'/partials/rr_msq'},
                    18: {controller: "diagramQuestion", templateUrl:'/partials/rr_diagram_question'},
                    19: {controller: "rQuestion", templateUrl: "/partials/rr_r"},
                    20: {controller: "meanStackQuestion", templateUrl: "/partials/rr_meanstack"},
                    21: {controller: "mediaQuestion", templateUrl: "/partials/rr_audio"},
                    22: {controller: "mediaQuestion", templateUrl: "/partials/rr_video"},
                    98: {controller: "multipleQuestions", templateUrl: "/partials/rr_multipleQuestions"}
                };

                return {
                    controllerProvider: function ($stateParams) {

                        return map[$stateParams.q].controller + "Ctrl";
                    },
                    templateUrl: function ($stateParams) {

                        return map[$stateParams.q].templateUrl;
                    },
                    resolve: {

                        getter: function ($stateParams, $q) {

                            return controllerResolver(map[$stateParams.q].controller).getter($q);
                        }
                    }
                };
            }

            var isSystemCheck = location.pathname == "/system-check";
            $urlRouterProvider.otherwise(isSystemCheck ? "systemCheck" : "diagnostics");
            $stateProvider
                .state('landing', {
                    url: '/landing',
                    templateUrl: '/partials/landing',
                    resolve: controllerResolver("landing"),
                    controller: 'LandingCtrl',
                    onEnter: function () {
                        document.title = "Contests and assessments for multiple jobs, skills and profiles";
                    }
                })
                .state('diagnostics', {
                    url: '/diagnostics',
                    templateUrl: '/partials/diagnostics',
                    resolve: controllerResolver("diagnostics"),
                    controller: 'DiagnosticsCtrl',
                    onEnter: function () {
                        document.title = "Verifying System Settings";                        
                    }
                })
                .state('systemCheck', {
                    url: '/systemCheck',
                    templateUrl: '/partials/diagnostics',
                    resolve: controllerResolver("diagnostics"),
                    controller: 'DiagnosticsCtrl',
                    onEnter: function () {
                        document.title = "Verifying System Settings";
                    }
                })
                .state('error', {
                    url: '/error',
                    templateUrl: '/partials/error',
                    onEnter: function () {
                        document.title = "Error occurred";
                    }
                })
                .state('instructions', {
                    url: '/instructions',
                    templateUrl: '/partials/instructions',
                    resolve: controllerResolver("instructions"),
                    controller: 'InstructionsCtrl',
                    onEnter: function () {
                        document.title = "Read instruction before starting the test";
                    }

                })
                .state('registration', {
                    url: '/registration',
                    templateUrl: '/partials/registration',
                    resolve: controllerResolver("registration"),
                    controller: 'RegistrationCtrl',
                    onEnter: function () {
                        document.title = "Register yourself for the assessment";
                    }
                })
                .state('authorization', {
                    url: '/authorization',
                    templateUrl: '/partials/authorization',
                    resolve: controllerResolver("authorization"),
                    controller: 'AuthorizationCtrl',
                    onEnter: function () {
                        document.title = "Provide authorization details";
                    }
                })
                .state('startTest', {
                    url: '/startTest',
                    templateUrl: '/partials/startTest',
                    resolve: controllerResolver("startTest"),
                    controller: 'StartTestCtrl',
                    onEnter: function () {
                        document.title = "Test loaded";
                    }
                })
                .state('resume', {
                    url: '/resume',
                    templateUrl: '/partials/resume',
                    resolve: controllerResolver("resume"),
                    controller: 'ResumeCtrl',
                    onEnter: function () {
                        document.title = "Register yourself for the assessment";
                    }
                })
                .state('testApi', {
                    url: '/testApi',
                    templateUrl: '/partials/diagnostics',
                    resolve: controllerResolver("diagnostics"),
                    controller: 'DiagnosticsCtrl',
                    onEnter: function() {
                        document.title = 'Online Test Window';
                    }
                })
                .state('testWindow', {
                    templateUrl: "/partials/testWindow",
                    url: '/testWindow',
                    resolve: controllerResolver("testWindow"),
                    controller: 'TestWindowCtrl',
                    onEnter: function() {
                        document.title = 'Online Test Window';
                    }
                })
                .state('testWindow.section', {
                    url: '/:s',
                    resolve: controllerResolver("testWindowSection"),
                    views: {
                        "section": {
                            controller: "TestWindowSectionCtrl",
                            templateUrl: '/partials/testWindowSection'
                        }
                    }
                })
                .state('testWindow.section.question', {
                    url: '/:i/:q',
                    views: {
                        "question": questionControllerResolver()
                    }
                })
                .state('result', {
                    url: '/result',
                    templateUrl: '/partials/result',
                    resolve: controllerResolver("result"),
                    controller: 'ResultCtrl',
                    onEnter: function() {
                        document.title = 'Candidate Result';
                    }
                })
                .state('feedback', {
                    url: '/feedback',
                    templateUrl: '/partials/feedback',
                    resolve: controllerResolver("feedback"),
                    controller: 'FeedbackCtrl'
                });
        }]);

    mettl.run(function ($rootScope, $state) {
        $rootScope.$state = $state;
        $rootScope.$on("$stateChangeSuccess", function (event, next, current) {
            window.history.go(1);
        });
    });

    mettl.controller("appCtrl", ["$scope", "$location", function ($scope, $location) {
    	$scope.$on('$viewContentLoaded', function(){
		    $location.replace(); //clear last history route
		});
    	document.oncontextmenu = function () {
            return false;
        };
    }]);

    return mettl;
});
