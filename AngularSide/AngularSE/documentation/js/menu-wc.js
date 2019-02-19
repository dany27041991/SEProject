'use strict';


customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">angular-se documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                        <li class="link">
                            <a href="dependencies.html" data-type="chapter-link">
                                <span class="icon ion-ios-list"></span>Dependencies
                            </a>
                        </li>
                    </ul>
                </li>
                    <li class="chapter modules">
                        <a data-type="chapter-link" href="modules.html">
                            <div class="menu-toggler linked" data-toggle="collapse" ${ isNormalMode ?
                                'data-target="#modules-links"' : 'data-target="#xs-modules-links"' }>
                                <span class="icon ion-ios-archive"></span>
                                <span class="link-name">Modules</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                        </a>
                        <ul class="links collapse" ${ isNormalMode ? 'id="modules-links"' : 'id="xs-modules-links"' }>
                            <li class="link">
                                <a href="modules/AppModule.html" data-type="entity-link">AppModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' : 'data-target="#xs-components-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' :
                                            'id="xs-components-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' }>
                                            <li class="link">
                                                <a href="components/AppComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">AppComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/DetailsecretaryreportingComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">DetailsecretaryreportingComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/DidacticcalendarComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">DidacticcalendarComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ExceptionGetDataComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ExceptionGetDataComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/FooterComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">FooterComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/HeaderComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">HeaderComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/HomeComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">HomeComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/InsertactivityComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">InsertactivityComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/InsertclassroomComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">InsertclassroomComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/InsertstudycourseComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">InsertstudycourseComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/InsertsubjectComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">InsertsubjectComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/InsertuserComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">InsertuserComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LoginComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LoginComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/NavbarComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">NavbarComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProfessorComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProfessorComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProfreportingComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProfreportingComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/SecretaryComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">SecretaryComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/SecretaryreportingComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">SecretaryreportingComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/SignupComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">SignupComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/StudentComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">StudentComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/SuccessfulComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">SuccessfulComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/UploadComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">UploadComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ViewreportingComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ViewreportingComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                                <li class="chapter inner">
                                    <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                        'data-target="#directives-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' : 'data-target="#xs-directives-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' }>
                                        <span class="icon ion-md-code-working"></span>
                                        <span>Directives</span>
                                        <span class="icon ion-ios-arrow-down"></span>
                                    </div>
                                    <ul class="links collapse" ${ isNormalMode ? 'id="directives-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' :
                                        'id="xs-directives-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' }>
                                        <li class="link">
                                            <a href="directives/CompareValidatorDirective.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules">CompareValidatorDirective</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="chapter inner">
                                    <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                        'data-target="#injectables-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' : 'data-target="#xs-injectables-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' }>
                                        <span class="icon ion-md-arrow-round-down"></span>
                                        <span>Injectables</span>
                                        <span class="icon ion-ios-arrow-down"></span>
                                    </div>
                                    <ul class="links collapse" ${ isNormalMode ? 'id="injectables-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' :
                                        'id="xs-injectables-links-module-AppModule-34ac692b213cff0e8a51ff2fbcb84248"' }>
                                        <li class="link">
                                            <a href="injectables/AuthService.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>AuthService</a>
                                        </li>
                                    </ul>
                                </li>
                            </li>
                            <li class="link">
                                <a href="modules/RoutingModuleModule.html" data-type="entity-link">RoutingModuleModule</a>
                            </li>
                </ul>
                </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#classes-links"' :
                            'data-target="#xs-classes-links"' }>
                            <span class="icon ion-ios-paper"></span>
                            <span>Classes</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse" ${ isNormalMode ? 'id="classes-links"' : 'id="xs-classes-links"' }>
                            <li class="link">
                                <a href="classes/AccessToLocalStorage.html" data-type="entity-link">AccessToLocalStorage</a>
                            </li>
                            <li class="link">
                                <a href="classes/Activity.html" data-type="entity-link">Activity</a>
                            </li>
                            <li class="link">
                                <a href="classes/ActivityCalendar.html" data-type="entity-link">ActivityCalendar</a>
                            </li>
                            <li class="link">
                                <a href="classes/ActivityType.html" data-type="entity-link">ActivityType</a>
                            </li>
                            <li class="link">
                                <a href="classes/ActivityWithoutClassroom.html" data-type="entity-link">ActivityWithoutClassroom</a>
                            </li>
                            <li class="link">
                                <a href="classes/AppPage.html" data-type="entity-link">AppPage</a>
                            </li>
                            <li class="link">
                                <a href="classes/Calendar.html" data-type="entity-link">Calendar</a>
                            </li>
                            <li class="link">
                                <a href="classes/Classroom.html" data-type="entity-link">Classroom</a>
                            </li>
                            <li class="link">
                                <a href="classes/Exam.html" data-type="entity-link">Exam</a>
                            </li>
                            <li class="link">
                                <a href="classes/Faculty.html" data-type="entity-link">Faculty</a>
                            </li>
                            <li class="link">
                                <a href="classes/Lesson.html" data-type="entity-link">Lesson</a>
                            </li>
                            <li class="link">
                                <a href="classes/Person.html" data-type="entity-link">Person</a>
                            </li>
                            <li class="link">
                                <a href="classes/PersonType.html" data-type="entity-link">PersonType</a>
                            </li>
                            <li class="link">
                                <a href="classes/Professor.html" data-type="entity-link">Professor</a>
                            </li>
                            <li class="link">
                                <a href="classes/ProfessorCalendar.html" data-type="entity-link">ProfessorCalendar</a>
                            </li>
                            <li class="link">
                                <a href="classes/Reporting.html" data-type="entity-link">Reporting</a>
                            </li>
                            <li class="link">
                                <a href="classes/ReportingRet.html" data-type="entity-link">ReportingRet</a>
                            </li>
                            <li class="link">
                                <a href="classes/Secretary.html" data-type="entity-link">Secretary</a>
                            </li>
                            <li class="link">
                                <a href="classes/SecretaryRet.html" data-type="entity-link">SecretaryRet</a>
                            </li>
                            <li class="link">
                                <a href="classes/State.html" data-type="entity-link">State</a>
                            </li>
                            <li class="link">
                                <a href="classes/Student.html" data-type="entity-link">Student</a>
                            </li>
                            <li class="link">
                                <a href="classes/StudyCourse.html" data-type="entity-link">StudyCourse</a>
                            </li>
                            <li class="link">
                                <a href="classes/StudyCourseCalendar.html" data-type="entity-link">StudyCourseCalendar</a>
                            </li>
                            <li class="link">
                                <a href="classes/Subject.html" data-type="entity-link">Subject</a>
                            </li>
                            <li class="link">
                                <a href="classes/SubjectCalendar.html" data-type="entity-link">SubjectCalendar</a>
                            </li>
                            <li class="link">
                                <a href="classes/SupportMaterial.html" data-type="entity-link">SupportMaterial</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#injectables-links"' :
                                'data-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse" ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/ProfessorService.html" data-type="entity-link">ProfessorService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/SecretaryService.html" data-type="entity-link">SecretaryService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#guards-links"' :
                            'data-target="#xs-guards-links"' }>
                            <span class="icon ion-ios-lock"></span>
                            <span>Guards</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse" ${ isNormalMode ? 'id="guards-links"' : 'id="xs-guards-links"' }>
                            <li class="link">
                                <a href="guards/RouteGuardService.html" data-type="entity-link">RouteGuardService</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#interfaces-links"' :
                            'data-target="#xs-interfaces-links"' }>
                            <span class="icon ion-md-information-circle-outline"></span>
                            <span>Interfaces</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse" ${ isNormalMode ? ' id="interfaces-links"' : 'id="xs-interfaces-links"' }>
                            <li class="link">
                                <a href="interfaces/ActivityCalendarInterface.html" data-type="entity-link">ActivityCalendarInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ActivityInterface.html" data-type="entity-link">ActivityInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ActivityTypeInterface.html" data-type="entity-link">ActivityTypeInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ActivityWithoutClassroomInterface.html" data-type="entity-link">ActivityWithoutClassroomInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/CalendarInterface.html" data-type="entity-link">CalendarInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ClassroomInterface.html" data-type="entity-link">ClassroomInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ExamInterface.html" data-type="entity-link">ExamInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/FacultyInterface.html" data-type="entity-link">FacultyInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/LessonInterface.html" data-type="entity-link">LessonInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/PersonInterface.html" data-type="entity-link">PersonInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/PersonTypeInterface.html" data-type="entity-link">PersonTypeInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ProfessorCalendarInterface.html" data-type="entity-link">ProfessorCalendarInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ProfessorInterface.html" data-type="entity-link">ProfessorInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ProfessorReporting.html" data-type="entity-link">ProfessorReporting</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ReportingInterface.html" data-type="entity-link">ReportingInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ReportingRetInterface.html" data-type="entity-link">ReportingRetInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ReportingSecInterface.html" data-type="entity-link">ReportingSecInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ResponseInterface.html" data-type="entity-link">ResponseInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SecretaryInterface.html" data-type="entity-link">SecretaryInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SecretaryReportingInterface.html" data-type="entity-link">SecretaryReportingInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SecretaryRetInterface.html" data-type="entity-link">SecretaryRetInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/StateInterface.html" data-type="entity-link">StateInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/StudentInterface.html" data-type="entity-link">StudentInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/StudyCourseCalendarInterface.html" data-type="entity-link">StudyCourseCalendarInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/StudyCourseInterface.html" data-type="entity-link">StudyCourseInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SubjectCalendarInterface.html" data-type="entity-link">SubjectCalendarInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SubjectInterface.html" data-type="entity-link">SubjectInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SupportMaterialInterface.html" data-type="entity-link">SupportMaterialInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/TypeLoggedInterface.html" data-type="entity-link">TypeLoggedInterface</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#miscellaneous-links"'
                            : 'data-target="#xs-miscellaneous-links"' }>
                            <span class="icon ion-ios-cube"></span>
                            <span>Miscellaneous</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse" ${ isNormalMode ? 'id="miscellaneous-links"' : 'id="xs-miscellaneous-links"' }>
                            <li class="link">
                                <a href="miscellaneous/enumerations.html" data-type="entity-link">Enums</a>
                            </li>
                            <li class="link">
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <a data-type="chapter-link" href="routes.html"><span class="icon ion-ios-git-branch"></span>Routes</a>
                        </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});