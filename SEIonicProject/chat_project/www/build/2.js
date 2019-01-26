webpackJsonp([2],{

/***/ 589:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProfilePageModule", function() { return ProfilePageModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(188);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__profile__ = __webpack_require__(608);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__components_components_module__ = __webpack_require__(593);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




var ProfilePageModule = /** @class */ (function () {
    function ProfilePageModule() {
    }
    ProfilePageModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["J" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_2__profile__["a" /* ProfilePage */],
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* IonicPageModule */].forChild(__WEBPACK_IMPORTED_MODULE_2__profile__["a" /* ProfilePage */]),
                __WEBPACK_IMPORTED_MODULE_3__components_components_module__["a" /* ComponentsModule */]
            ],
        })
    ], ProfilePageModule);
    return ProfilePageModule;
}());

//# sourceMappingURL=profile.module.js.map

/***/ }),

/***/ 593:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ComponentsModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(188);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__login_form_login_form_component__ = __webpack_require__(594);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__register_form_register_form_component__ = __webpack_require__(595);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__edit_profile_form_edit_profile_form_component__ = __webpack_require__(596);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__profile_view_profile_view_component__ = __webpack_require__(597);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__profile_search_profile_search_component__ = __webpack_require__(598);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__send_message_box_send_message_box_component__ = __webpack_require__(599);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__online_users_online_users_component__ = __webpack_require__(600);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__last_message_list_last_message_list_component__ = __webpack_require__(601);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_common__ = __webpack_require__(59);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var ComponentsModule = /** @class */ (function () {
    function ComponentsModule() {
    }
    ComponentsModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["J" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_2__login_form_login_form_component__["a" /* LoginFormComponent */],
                __WEBPACK_IMPORTED_MODULE_3__register_form_register_form_component__["a" /* RegisterFormComponent */],
                __WEBPACK_IMPORTED_MODULE_4__edit_profile_form_edit_profile_form_component__["a" /* EditProfileFormComponent */],
                __WEBPACK_IMPORTED_MODULE_5__profile_view_profile_view_component__["a" /* ProfileViewComponent */],
                __WEBPACK_IMPORTED_MODULE_6__profile_search_profile_search_component__["a" /* ProfileSearchComponent */],
                __WEBPACK_IMPORTED_MODULE_7__send_message_box_send_message_box_component__["a" /* SendMessageBoxComponent */],
                __WEBPACK_IMPORTED_MODULE_8__online_users_online_users_component__["a" /* OnlineUsersComponent */],
                __WEBPACK_IMPORTED_MODULE_9__last_message_list_last_message_list_component__["a" /* LastMessageListComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* IonicModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_common__["b" /* CommonModule */]
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_2__login_form_login_form_component__["a" /* LoginFormComponent */],
                __WEBPACK_IMPORTED_MODULE_3__register_form_register_form_component__["a" /* RegisterFormComponent */],
                __WEBPACK_IMPORTED_MODULE_4__edit_profile_form_edit_profile_form_component__["a" /* EditProfileFormComponent */],
                __WEBPACK_IMPORTED_MODULE_5__profile_view_profile_view_component__["a" /* ProfileViewComponent */],
                __WEBPACK_IMPORTED_MODULE_6__profile_search_profile_search_component__["a" /* ProfileSearchComponent */],
                __WEBPACK_IMPORTED_MODULE_7__send_message_box_send_message_box_component__["a" /* SendMessageBoxComponent */],
                __WEBPACK_IMPORTED_MODULE_8__online_users_online_users_component__["a" /* OnlineUsersComponent */],
                __WEBPACK_IMPORTED_MODULE_9__last_message_list_last_message_list_component__["a" /* LastMessageListComponent */]
            ]
        })
    ], ComponentsModule);
    return ComponentsModule;
}());

//# sourceMappingURL=components.module.js.map

/***/ }),

/***/ 594:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginFormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(188);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__ = __webpack_require__(333);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = y[op[0] & 2 ? "return" : op[0] ? "throw" : "next"]) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [0, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};



var LoginFormComponent = /** @class */ (function () {
    function LoginFormComponent(auth, navCtrl) {
        this.auth = auth;
        this.navCtrl = navCtrl;
        this.account = {};
        this.loginStatus = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */]();
    }
    LoginFormComponent.prototype.login = function () {
        return __awaiter(this, void 0, void 0, function () {
            var loginResponse;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.auth.signInWithEmailAndPassword(this.account)];
                    case 1:
                        loginResponse = _a.sent();
                        this.loginStatus.emit(loginResponse);
                        return [2 /*return*/];
                }
            });
        });
    };
    /* navigateToPage(pageName: string) {
      // costrutto per if-else
      pageName === 'InboxPage' ? this.navCtrl.setRoot(pageName) : this.navCtrl.push(pageName);
    } */
    LoginFormComponent.prototype.navigateToRegisterPage = function () {
        this.navCtrl.push('RegisterPage');
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["P" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */])
    ], LoginFormComponent.prototype, "loginStatus", void 0);
    LoginFormComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-login-form',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/login-form/login-form.component.html"*/'  <form #loginForm="ngForm" novalidate>\n  <ion-card>\n    <ion-card-content>\n      <ion-item>\n        <ion-label floating>Email Address</ion-label>\n        <ion-input [(ngModel)]="account.email" type="email" name="email" #email="ngModel" required pattern="[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"></ion-input>\n      </ion-item>\n\n      <div padding *ngIf="email.invalid && email.dirty">\n        <span class="global__input-error">Email address is not valid.</span>\n      </div>\n\n      <ion-item>\n        <ion-label floating>Password</ion-label>\n        <ion-input [(ngModel)]="account.password" type="password" name="password" #password="ngModel" required pattern="(?=^.{6,}$)((?=.*\d)|(?=.*W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"></ion-input>\n      </ion-item>\n\n      <div padding *ngIf="password.invalid && password.dirty">\n        <span class="global__input-error">Password must be at least 6 characters and have one uppercase letter.</span>\n      </div>\n\n    </ion-card-content>\n    <ion-row class="login-form__buttons">\n      <div>\n        <button ion-button (click)="navigateToRegisterPage()" color="danger">Register</button>\n        <button ion-button (click)="login()" color="primary" [disabled]="loginForm.invalid">Login</button>\n      </div>\n    </ion-row>\n  </ion-card>\n</form>'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/login-form/login-form.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__["a" /* AuthProvider */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */]])
    ], LoginFormComponent);
    return LoginFormComponent;
}());

//# sourceMappingURL=login-form.component.js.map

/***/ }),

/***/ 595:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RegisterFormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__providers_auth_auth_service__ = __webpack_require__(333);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = y[op[0] & 2 ? "return" : op[0] ? "throw" : "next"]) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [0, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};


var RegisterFormComponent = /** @class */ (function () {
    function RegisterFormComponent(auth) {
        this.auth = auth;
        this.account = {};
        this.registerStatus = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */]();
    }
    RegisterFormComponent.prototype.register = function () {
        return __awaiter(this, void 0, void 0, function () {
            var result, e_1;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4 /*yield*/, this.auth.createUserWithEmailAndPassword(this.account)];
                    case 1:
                        result = _a.sent();
                        this.registerStatus.emit(result);
                        return [3 /*break*/, 3];
                    case 2:
                        e_1 = _a.sent();
                        console.error(e_1);
                        this.registerStatus.emit(e_1);
                        return [3 /*break*/, 3];
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["P" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */])
    ], RegisterFormComponent.prototype, "registerStatus", void 0);
    RegisterFormComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-register-form',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/register-form/register-form.component.html"*/'<form #registerForm="ngForm" novalidate>  \n  <ion-card>\n    <ion-card-content>\n      <ion-item>\n        <ion-label floating>Email Address</ion-label>\n        <ion-input [(ngModel)]="account.email" type="email" name="email" #email="ngModel" required pattern="[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"></ion-input>\n      </ion-item>\n\n      <div padding *ngIf="email.invalid && email.dirty">\n        <span class="global__input-error">Email address is not valid.</span>\n      </div>\n\n      <ion-item>\n        <ion-label floating>Password</ion-label>\n        <ion-input [(ngModel)]="account.password" type="password" name="password" #password="ngModel" required pattern="(?=^.{6,}$)((?=.*\d)|(?=.*W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"></ion-input>\n      </ion-item>\n\n      <div padding *ngIf="password.invalid && password.dirty">\n        <span class="global__input-error">Password must be at least 6 characters and have one uppercase letter.</span>\n      </div>\n    </ion-card-content>\n    <ion-row class="register-form__button">\n      <button ion-button (click)="register()" color="danger" [disabled]="registerForm.invalid">Register</button>\n    </ion-row>\n  </ion-card>\n</form>'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/register-form/register-form.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__providers_auth_auth_service__["a" /* AuthProvider */]])
    ], RegisterFormComponent);
    return RegisterFormComponent;
}());

//# sourceMappingURL=register-form.component.js.map

/***/ }),

/***/ 596:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EditProfileFormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__ = __webpack_require__(334);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__ = __webpack_require__(333);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = y[op[0] & 2 ? "return" : op[0] ? "throw" : "next"]) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [0, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};



var EditProfileFormComponent = /** @class */ (function () {
    function EditProfileFormComponent(auth, data) {
        var _this = this;
        this.auth = auth;
        this.data = data;
        this.saveProfileResult = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */]();
        this.authenticatedUser$ = this.auth.getAuthenticatedUser().subscribe(function (user) {
            _this.authenticatedUser = user;
        });
    }
    EditProfileFormComponent.prototype.saveProfile = function () {
        return __awaiter(this, void 0, void 0, function () {
            var result;
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        if (!this.authenticatedUser) return [3 /*break*/, 2];
                        this.profile.email = this.authenticatedUser.email;
                        return [4 /*yield*/, this.data.saveProfile(this.authenticatedUser, this.profile)];
                    case 1:
                        result = _a.sent();
                        //console.log(result);
                        this.saveProfileResult.emit(result);
                        _a.label = 2;
                    case 2: return [2 /*return*/];
                }
            });
        });
    };
    EditProfileFormComponent.prototype.ngOnDestroy = function () {
        this.authenticatedUser$.unsubscribe();
    };
    EditProfileFormComponent.prototype.ngOnInit = function () {
        if (!this.profile) {
            this.profile = {};
        }
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["P" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */])
    ], EditProfileFormComponent.prototype, "saveProfileResult", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["E" /* Input */])(),
        __metadata("design:type", Object)
    ], EditProfileFormComponent.prototype, "profile", void 0);
    EditProfileFormComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-edit-profile-form',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/edit-profile-form/edit-profile-form.component.html"*/'<ion-card>\n  <ion-card-content>\n    <ion-item>\n      <ion-label floating>First Name</ion-label>\n      <ion-input type="text" [(ngModel)]="profile.firstName"></ion-input>\n    </ion-item>\n    <ion-item>\n      <ion-label floating>Last Name</ion-label>\n      <ion-input type="text" [(ngModel)]="profile.lastName"></ion-input>\n    </ion-item>\n    <ion-item>\n      <ion-label floating>Date of Birth</ion-label>\n      <ion-datetime displayFormat="DD/MM/YYYY" [(ngModel)]="profile.dateOfBirth"></ion-datetime>\n    </ion-item>\n  </ion-card-content>\n</ion-card>\n\n<button ion-button (click)="saveProfile()">Save</button>'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/edit-profile-form/edit-profile-form.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__["a" /* AuthProvider */], __WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__["a" /* DataProvider */]])
    ], EditProfileFormComponent);
    return EditProfileFormComponent;
}());

//# sourceMappingURL=edit-profile-form.component.js.map

/***/ }),

/***/ 597:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfileViewComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__ = __webpack_require__(334);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__ = __webpack_require__(333);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_ionic_angular__ = __webpack_require__(188);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ProfileViewComponent = /** @class */ (function () {
    function ProfileViewComponent(data, auth, loading) {
        this.data = data;
        this.auth = auth;
        this.loading = loading;
        this.existingProfile = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */]();
        this.loader = this.loading.create({
            content: 'Loading profile ...'
        });
    }
    ProfileViewComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.loader.present();
        /*this.data.getAuthenticatedUserProfile().subscribe(profile => {
            this.userProfile = <Profile>profile;
            this.existingProfile.emit(this.userProfile);
            this.loader.dismiss();
            })*/
        this.auth.getAuthenticatedUser().subscribe(function (auth) {
            _this.authUser = auth;
            if (_this.authUser !== null) {
                _this.data.getProfile(_this.authUser).subscribe(function (profile) {
                    _this.userProfile = profile;
                    _this.existingProfile.emit(_this.userProfile);
                    _this.loader.dismiss();
                });
            }
        });
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["P" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */])
    ], ProfileViewComponent.prototype, "existingProfile", void 0);
    ProfileViewComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-profile-view',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/profile-view/profile-view.component.html"*/'<div class="profile-view__image-container">\n    <img class="profile-view__image" src="assets/imgs/profile-placeholder.png" alt="Avatar">\n</div>\n\n<div *ngIf="userProfile">\n    <ion-card>\n        <ion-card-content>\n            <ion-item>\n                <ion-label floating>First Name</ion-label>\n                <ion-input [value]="userProfile.firstName" [readonly]="true"></ion-input>\n            </ion-item>\n            <ion-item>\n                <ion-label floating>Last Name</ion-label>\n                <ion-input [value]="userProfile.lastName" [readonly]="true"></ion-input>\n            </ion-item>\n            <ion-item>\n                <ion-label floating>Email</ion-label>\n                <ion-input [value]="userProfile.email" [readonly]="true"></ion-input>\n            </ion-item>\n            <ion-item>\n                <ion-label floating>Date of Birth</ion-label>\n                <ion-input [value]="userProfile.dateOfBirth" [readonly]="true"></ion-input>\n            </ion-item>\n        </ion-card-content>\n    </ion-card>\n</div>'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/profile-view/profile-view.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__["a" /* DataProvider */], __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__["a" /* AuthProvider */], __WEBPACK_IMPORTED_MODULE_3_ionic_angular__["g" /* LoadingController */]])
    ], ProfileViewComponent);
    return ProfileViewComponent;
}());

//# sourceMappingURL=profile-view.component.js.map

/***/ }),

/***/ 598:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfileSearchComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__ = __webpack_require__(334);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ProfileSearchComponent = /** @class */ (function () {
    function ProfileSearchComponent(data) {
        this.data = data;
        var profile = JSON.parse(localStorage.getItem('selectedUser'));
        this.keyUserLogged = profile.mykey;
        this.selectedProfile = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */]();
    }
    ProfileSearchComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.data.getAllUsers().subscribe(function (profiles) {
            _this.allProfileList = profiles;
        });
    };
    ProfileSearchComponent.prototype.searchUser = function (query) {
        var _this = this;
        var trimmedQuery = query.trim();
        if (trimmedQuery === query) {
            this.data.searchUser(query).subscribe(function (profiles) {
                _this.profileList = profiles;
            });
        }
    };
    ProfileSearchComponent.prototype.selectProfile = function (profile) {
        this.selectedProfile.emit(profile);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["P" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */])
    ], ProfileSearchComponent.prototype, "selectedProfile", void 0);
    ProfileSearchComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-profile-search',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/profile-search/profile-search.component.html"*/'<ion-searchbar id="searchbar" [(ngModel)]="query" (ionChange)="searchUser(query)"></ion-searchbar>\n\n<ion-list no-lines *ngIf="profileList?.length > 0">\n    <ion-item no-lines class="lines" no-lines *ngFor="let profile of profileList" (click)="selectProfile(profile)">\n      <ion-item no-lines *ngIf="profile.mykey !== keyUserLogged">\n          <ion-avatar item-left>\n              <img src="assets/imgs/profile-placeholder.png" alt="Avatar">\n          </ion-avatar>\n        <h2> <b> {{ profile.firstName }} {{ profile.lastName  }} </b> </h2>\n      </ion-item>\n    </ion-item>\n</ion-list>\n\n<ion-item-divider id="alluser">All Users</ion-item-divider>\n<ion-list>\n  <ion-item no-lines class="lines" no-lines *ngFor="let profile of allProfileList" (click)="selectProfile(profile)">\n    <ion-item class="profiles" no-lines *ngIf="profile.mykey !== keyUserLogged">\n      <ion-avatar item-left>\n        <img src="assets/imgs/profile-placeholder.png" alt="Avatar">\n      </ion-avatar>\n      <h2> <b>{{ profile.firstName }} {{ profile.lastName  }} </b> </h2>\n    </ion-item>\n  </ion-item>\n</ion-list>\n'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/profile-search/profile-search.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__["a" /* DataProvider */]])
    ], ProfileSearchComponent);
    return ProfileSearchComponent;
}());

//# sourceMappingURL=profile-search.component.js.map

/***/ }),

/***/ 599:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SendMessageBoxComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SendMessageBoxComponent = /** @class */ (function () {
    function SendMessageBoxComponent() {
        this.sendMessage = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */]();
    }
    SendMessageBoxComponent.prototype.send = function () {
        this.sendMessage.emit(this.content);
        this.content = "";
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["P" /* Output */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["w" /* EventEmitter */])
    ], SendMessageBoxComponent.prototype, "sendMessage", void 0);
    SendMessageBoxComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-send-message-box',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/send-message-box/send-message-box.component.html"*/'<ion-grid>\n  <ion-row>\n    <ion-col col-9>\n      <ion-textarea [(ngModel)]="content" placeholder="Enter message ..."></ion-textarea>\n    </ion-col>\n    <ion-col col-3>\n      <button clear ion-button (click)="send()">Submit</button>\n    </ion-col>\n  </ion-row>\n</ion-grid>'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/send-message-box/send-message-box.component.html"*/
        }),
        __metadata("design:paramtypes", [])
    ], SendMessageBoxComponent);
    return SendMessageBoxComponent;
}());

//# sourceMappingURL=send-message-box.component.js.map

/***/ }),

/***/ 600:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OnlineUsersComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__ = __webpack_require__(334);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__ = __webpack_require__(333);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_ionic_angular__ = __webpack_require__(188);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var OnlineUsersComponent = /** @class */ (function () {
    function OnlineUsersComponent(data, auth, navCtrl) {
        this.data = data;
        this.auth = auth;
        this.navCtrl = navCtrl;
        this.currentProfile = JSON.parse(localStorage.getItem('selectedUser'));
        this.userKey = this.currentProfile.mykey;
    }
    OnlineUsersComponent.prototype.ngOnInit = function () {
        this.setUserOnline();
        this.getOnlineUsers();
    };
    OnlineUsersComponent.prototype.setUserOnline = function () {
        var _this = this;
        this.auth.getAuthenticatedUser().subscribe(function (auth) {
            _this.authUser = auth;
            if (_this.authUser !== null) {
                _this.data.getProfile(_this.authUser).subscribe(function (profile) {
                    _this.data.setUserOnline(profile);
                });
            }
        });
    };
    OnlineUsersComponent.prototype.getOnlineUsers = function () {
        this.userList = this.data.getOnlineUsers();
    };
    OnlineUsersComponent.prototype.openChat = function (profile) {
        this.navCtrl.push('MessagePage', { profile: profile });
    };
    OnlineUsersComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-online-users',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/online-users/online-users.component.html"*/'<ion-list>\n  <ion-item-divider id="onlineuser">Online User</ion-item-divider>\n  <ion-item no-lines *ngFor="let user of userList | async" (click)="openChat(user)" >\n    <ion-item no-lines *ngIf="user.mykey !== userKey">\n      <ion-avatar item-left>\n        <img src="assets/imgs/profile-placeholder.png" alt="Avatar">\n      </ion-avatar>\n      <h2 id="profile">{{ user.firstName }} {{ user.lastName }} </h2> <p id="online">Online</p>\n    </ion-item>\n  </ion-item>\n</ion-list>\n'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/online-users/online-users.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__providers_data_data_service__["a" /* DataProvider */], __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__["a" /* AuthProvider */], __WEBPACK_IMPORTED_MODULE_3_ionic_angular__["h" /* NavController */]])
    ], OnlineUsersComponent);
    return OnlineUsersComponent;
}());

//# sourceMappingURL=online-users.component.js.map

/***/ }),

/***/ 601:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LastMessageListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__providers_chat_chat_service__ = __webpack_require__(335);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(188);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LastMessageListComponent = /** @class */ (function () {
    function LastMessageListComponent(chat, navCtrl) {
        var _this = this;
        this.chat = chat;
        this.navCtrl = navCtrl;
        this.lastMexObj = [];
        this.chat.last.subscribe(function (data) {
            _this.lastMexObj.splice(0);
            Object.keys(data).forEach(function (k) {
                _this.lastMexObj.push(data[k]);
            });
        });
        /*this.currentProfile = JSON.parse(localStorage.getItem('selectedUser'));
        this.userKey = this.currentProfile.mykey;
        this.chat.last.subscribe((data: Message[]) => {
          Object.keys(data).forEach(k => {
            const keysender = data[k].userFromId;
            let mexRiceived: Message = data[k];
            if(this.userKey !== keysender) {
              this.lastMexObj.push(mexRiceived);
            }
          });
        })*/
    }
    LastMessageListComponent.prototype.ngOnInit = function () {
        this.chat.getLastMessageForUser();
    };
    LastMessageListComponent.prototype.navigateToMessage = function (message) {
        var selectedProfile = {
            mykey: message.userFromId,
            firstName: message.userFromProfile.firstName,
            lastName: message.userFromProfile.lastName
        };
        this.navCtrl.push('MessagePage', { profile: selectedProfile });
    };
    LastMessageListComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-last-message-list',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/last-message-list/last-message-list.component.html"*/'<ion-list>\n  <ion-item-divider id="lastmessages">Last Messages</ion-item-divider>\n\n  <ion-item *ngFor="let message of lastMexObj">\n    <ion-item no-lines (click)="navigateToMessage(message)">\n      <ion-avatar item-left>\n        <img src="assets/imgs/profile-placeholder.png" alt="Avatar">\n      </ion-avatar>\n      <h2 id="profile">{{ message?.userFromProfile?.firstName }} {{ message?.userFromProfile?.lastName }}</h2>\n      <p>{{ message?.content }}</p>\n    </ion-item>\n  </ion-item>\n</ion-list>\n'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/components/last-message-list/last-message-list.component.html"*/
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__providers_chat_chat_service__["a" /* ChatService */], __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["h" /* NavController */]])
    ], LastMessageListComponent);
    return LastMessageListComponent;
}());

//# sourceMappingURL=last-message-list.component.js.map

/***/ }),

/***/ 608:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfilePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(188);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__ = __webpack_require__(333);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__providers_data_data_service__ = __webpack_require__(334);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ProfilePage = /** @class */ (function () {
    function ProfilePage(navCtrl, auth, data) {
        this.navCtrl = navCtrl;
        this.auth = auth;
        this.data = data;
        this.existingProfile = {};
    }
    ProfilePage.prototype.getExistingProfile = function (profile) {
        this.existingProfile = profile;
    };
    ProfilePage.prototype.navigateToEditProfilePage = function () {
        this.navCtrl.push('EditProfilePage', { existingProfile: this.existingProfile });
    };
    ProfilePage.prototype.signout = function () {
        var key = JSON.parse(localStorage.getItem('selectedUser')).mykey;
        this.data.deleteUserLogoutOnline(key);
        this.auth.signOut();
        localStorage.removeItem('selectedUser');
        localStorage.removeItem('firebase:host:ionic-chat-44e31.firebaseio.com');
        this.navCtrl.setRoot('LoginPage');
    };
    ProfilePage = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'page-profile',template:/*ion-inline-start:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/pages/profile/profile.html"*/'<ion-header>\n  <ion-navbar color="dark">\n    <ion-title>Profile</ion-title>\n    <ion-buttons end>\n      <button ion-button (click)="navigateToEditProfilePage()">Edit</button>\n    </ion-buttons>\n  </ion-navbar>\n</ion-header>\n<ion-content>\n\n  <app-profile-view (existingProfile)="getExistingProfile($event)"></app-profile-view>\n\n  <button ion-button block (click)="signout()">Logout</button>\n\n</ion-content>\n'/*ion-inline-end:"/Users/danilogiovannico/Desktop/SEIonicProject/chat_project/src/pages/profile/profile.html"*/,
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_2__providers_auth_auth_service__["a" /* AuthProvider */], __WEBPACK_IMPORTED_MODULE_3__providers_data_data_service__["a" /* DataProvider */]])
    ], ProfilePage);
    return ProfilePage;
}());

//# sourceMappingURL=profile.js.map

/***/ })

});
//# sourceMappingURL=2.js.map