import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NavComponent } from './components/nav/nav.component';
import { LoginAddComponent } from './components/login/login-add/login-add.component';
import { AtivosComponent } from './components/view/ativo/ativos/ativos.component';
import { CategorysComponent } from './components/view/category/categorys/categorys.component';
import { LocalizationComponent } from './components/view/localization/localization/localization.component';
import { CategoryComponent } from './components/view/category/category/category.component';
import { LocalizationsComponent } from './components/view/localization/localizations/localizations.component';
import { AtivoComponent } from './components/view/ativo/ativo/ativo.component';

export const routes: Routes = [
    { path: 'login', component: LoginAddComponent },

    {
        path: '', component: NavComponent,
        children: [
            {
                path: "home", component: HomeComponent
            },
            {
                path: "ativo", component: AtivoComponent,
            },
            {
                path: "ativos", component: AtivosComponent,
            },
            {
                path: 'categorys', component: CategorysComponent,

            },
            {
                path: 'category', component: CategoryComponent,

            },
            {
                path: 'localizations', component: LocalizationsComponent,

            },
            {
                path: 'localization', component: LocalizationComponent,

            },

        ]
    },



];
