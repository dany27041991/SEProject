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
                    <a href="index.html" data-type="index-link">chat documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
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
                                            'data-target="#components-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' : 'data-target="#xs-components-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' :
                                            'id="xs-components-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' }>
                                            <li class="link">
                                                <a href="components/MyApp.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">MyApp</a>
                                            </li>
                                        </ul>
                                    </li>
                                <li class="chapter inner">
                                    <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                        'data-target="#injectables-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' : 'data-target="#xs-injectables-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' }>
                                        <span class="icon ion-md-arrow-round-down"></span>
                                        <span>Injectables</span>
                                        <span class="icon ion-ios-arrow-down"></span>
                                    </div>
                                    <ul class="links collapse" ${ isNormalMode ? 'id="injectables-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' :
                                        'id="xs-injectables-links-module-AppModule-9e2a182299b08c11a4721a27cb03bf4f"' }>
                                        <li class="link">
                                            <a href="injectables/AuthProvider.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>AuthProvider</a>
                                        </li>
                                        <li class="link">
                                            <a href="injectables/ChatService.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>ChatService</a>
                                        </li>
                                        <li class="link">
                                            <a href="injectables/DataProvider.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>DataProvider</a>
                                        </li>
                                        <li class="link">
                                            <a href="injectables/ProfessorProvider.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>ProfessorProvider</a>
                                        </li>
                                        <li class="link">
                                            <a href="injectables/SecretaryProvider.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>SecretaryProvider</a>
                                        </li>
                                        <li class="link">
                                            <a href="injectables/StudentProvider.html"
                                                data-type="entity-link" data-context="sub-entity" data-context-id="modules" }>StudentProvider</a>
                                        </li>
                                    </ul>
                                </li>
                            </li>
                            <li class="link">
                                <a href="modules/ChannelChatPageModule.html" data-type="entity-link">ChannelChatPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ChannelChatPageModule-5549e5aae5c603c9a4e2517b98ea3c00"' : 'data-target="#xs-components-links-module-ChannelChatPageModule-5549e5aae5c603c9a4e2517b98ea3c00"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ChannelChatPageModule-5549e5aae5c603c9a4e2517b98ea3c00"' :
                                            'id="xs-components-links-module-ChannelChatPageModule-5549e5aae5c603c9a4e2517b98ea3c00"' }>
                                            <li class="link">
                                                <a href="components/ChannelChatPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ChannelChatPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ChannelsPageModule.html" data-type="entity-link">ChannelsPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ChannelsPageModule-b9a2419e20f40ba5997e6e022dc8a553"' : 'data-target="#xs-components-links-module-ChannelsPageModule-b9a2419e20f40ba5997e6e022dc8a553"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ChannelsPageModule-b9a2419e20f40ba5997e6e022dc8a553"' :
                                            'id="xs-components-links-module-ChannelsPageModule-b9a2419e20f40ba5997e6e022dc8a553"' }>
                                            <li class="link">
                                                <a href="components/ChannelsPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ChannelsPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ComponentsModule.html" data-type="entity-link">ComponentsModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ComponentsModule-58b2ce93659d29975dbd42f4af8ef16c"' : 'data-target="#xs-components-links-module-ComponentsModule-58b2ce93659d29975dbd42f4af8ef16c"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ComponentsModule-58b2ce93659d29975dbd42f4af8ef16c"' :
                                            'id="xs-components-links-module-ComponentsModule-58b2ce93659d29975dbd42f4af8ef16c"' }>
                                            <li class="link">
                                                <a href="components/DownloadStudentComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">DownloadStudentComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/EditProfileFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">EditProfileFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LastChannelMessageComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LastChannelMessageComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LastMessageListComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LastMessageListComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LastRateProfessorComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LastRateProfessorComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LastUploadMaterialComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LastUploadMaterialComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/LoginFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LoginFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/OnlineUsersComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">OnlineUsersComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProfileSearchComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProfileSearchComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/ProfileViewComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProfileViewComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/RegisterFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">RegisterFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/SendMessageBoxComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">SendMessageBoxComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/DownloadPageModule.html" data-type="entity-link">DownloadPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-DownloadPageModule-cad5395a669ed0f319168d29f682e80a"' : 'data-target="#xs-components-links-module-DownloadPageModule-cad5395a669ed0f319168d29f682e80a"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-DownloadPageModule-cad5395a669ed0f319168d29f682e80a"' :
                                            'id="xs-components-links-module-DownloadPageModule-cad5395a669ed0f319168d29f682e80a"' }>
                                            <li class="link">
                                                <a href="components/DownloadPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">DownloadPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/EditProfilePageModule.html" data-type="entity-link">EditProfilePageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-EditProfilePageModule-6dc1f638e99fd2f1fdbe0f0c135982e1"' : 'data-target="#xs-components-links-module-EditProfilePageModule-6dc1f638e99fd2f1fdbe0f0c135982e1"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-EditProfilePageModule-6dc1f638e99fd2f1fdbe0f0c135982e1"' :
                                            'id="xs-components-links-module-EditProfilePageModule-6dc1f638e99fd2f1fdbe0f0c135982e1"' }>
                                            <li class="link">
                                                <a href="components/EditProfilePage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">EditProfilePage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/InboxPageModule.html" data-type="entity-link">InboxPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-InboxPageModule-a7df7bc05430b6424a3ec88bf12cf9c1"' : 'data-target="#xs-components-links-module-InboxPageModule-a7df7bc05430b6424a3ec88bf12cf9c1"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-InboxPageModule-a7df7bc05430b6424a3ec88bf12cf9c1"' :
                                            'id="xs-components-links-module-InboxPageModule-a7df7bc05430b6424a3ec88bf12cf9c1"' }>
                                            <li class="link">
                                                <a href="components/InboxPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">InboxPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/LoginPageModule.html" data-type="entity-link">LoginPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-LoginPageModule-a78a8a017528e6b245e587b572f2571d"' : 'data-target="#xs-components-links-module-LoginPageModule-a78a8a017528e6b245e587b572f2571d"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-LoginPageModule-a78a8a017528e6b245e587b572f2571d"' :
                                            'id="xs-components-links-module-LoginPageModule-a78a8a017528e6b245e587b572f2571d"' }>
                                            <li class="link">
                                                <a href="components/LoginPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">LoginPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/MessagePageModule.html" data-type="entity-link">MessagePageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-MessagePageModule-29e36545c6906cae653c04d32a01609e"' : 'data-target="#xs-components-links-module-MessagePageModule-29e36545c6906cae653c04d32a01609e"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-MessagePageModule-29e36545c6906cae653c04d32a01609e"' :
                                            'id="xs-components-links-module-MessagePageModule-29e36545c6906cae653c04d32a01609e"' }>
                                            <li class="link">
                                                <a href="components/MessagePage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">MessagePage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ModalRatePageModule.html" data-type="entity-link">ModalRatePageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ModalRatePageModule-43b20e58b2da35e03bc0a39d1c498c72"' : 'data-target="#xs-components-links-module-ModalRatePageModule-43b20e58b2da35e03bc0a39d1c498c72"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ModalRatePageModule-43b20e58b2da35e03bc0a39d1c498c72"' :
                                            'id="xs-components-links-module-ModalRatePageModule-43b20e58b2da35e03bc0a39d1c498c72"' }>
                                            <li class="link">
                                                <a href="components/ModalRatePage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ModalRatePage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ProfilePageModule.html" data-type="entity-link">ProfilePageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ProfilePageModule-57e7a2c92ad26b7a7b9279f062870fd5"' : 'data-target="#xs-components-links-module-ProfilePageModule-57e7a2c92ad26b7a7b9279f062870fd5"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ProfilePageModule-57e7a2c92ad26b7a7b9279f062870fd5"' :
                                            'id="xs-components-links-module-ProfilePageModule-57e7a2c92ad26b7a7b9279f062870fd5"' }>
                                            <li class="link">
                                                <a href="components/ProfilePage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">ProfilePage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/RegisterPageModule.html" data-type="entity-link">RegisterPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-RegisterPageModule-e12260d3b15ebda7d46ac641174516bd"' : 'data-target="#xs-components-links-module-RegisterPageModule-e12260d3b15ebda7d46ac641174516bd"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-RegisterPageModule-e12260d3b15ebda7d46ac641174516bd"' :
                                            'id="xs-components-links-module-RegisterPageModule-e12260d3b15ebda7d46ac641174516bd"' }>
                                            <li class="link">
                                                <a href="components/RegisterPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">RegisterPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/SearchUserPageModule.html" data-type="entity-link">SearchUserPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-SearchUserPageModule-f0d48a390371a47ab8461cd7bff652b7"' : 'data-target="#xs-components-links-module-SearchUserPageModule-f0d48a390371a47ab8461cd7bff652b7"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-SearchUserPageModule-f0d48a390371a47ab8461cd7bff652b7"' :
                                            'id="xs-components-links-module-SearchUserPageModule-f0d48a390371a47ab8461cd7bff652b7"' }>
                                            <li class="link">
                                                <a href="components/SearchUserPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">SearchUserPage</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/TabsPageModule.html" data-type="entity-link">TabsPageModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-TabsPageModule-192a8a485807ff567fa80bc38c5b65d4"' : 'data-target="#xs-components-links-module-TabsPageModule-192a8a485807ff567fa80bc38c5b65d4"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-TabsPageModule-192a8a485807ff567fa80bc38c5b65d4"' :
                                            'id="xs-components-links-module-TabsPageModule-192a8a485807ff567fa80bc38c5b65d4"' }>
                                            <li class="link">
                                                <a href="components/TabsPage.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">TabsPage</a>
                                            </li>
                                        </ul>
                                    </li>
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
                                <a href="interfaces/Account.html" data-type="entity-link">Account</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Channel.html" data-type="entity-link">Channel</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/ChannelMessage.html" data-type="entity-link">ChannelMessage</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/DownloadInterface.html" data-type="entity-link">DownloadInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/LoginResponse.html" data-type="entity-link">LoginResponse</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Message.html" data-type="entity-link">Message</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Professor.html" data-type="entity-link">Professor</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Profile.html" data-type="entity-link">Profile</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/RatingTeachingMaterial.html" data-type="entity-link">RatingTeachingMaterial</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Response.html" data-type="entity-link">Response</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/SubjectInterface.html" data-type="entity-link">SubjectInterface</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/TeachingMaterial.html" data-type="entity-link">TeachingMaterial</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/UploadInterface.html" data-type="entity-link">UploadInterface</a>
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
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
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