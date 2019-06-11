import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ECommerceComponent } from './e-commerce/e-commerce.component';
import { NotFoundComponent } from './miscellaneous/not-found/not-found.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [{
    path: 'dashboard',
    component: ECommerceComponent,
  }, {
    path: 'iot-dashboard',
    component: DashboardComponent,
  }, {
    path: 'ui-features',
    loadChildren: './ui-features/ui-features.module#UiFeaturesModule',
  }, {
    path: 'modal-overlays',
    loadChildren: './modal-overlays/modal-overlays.module#ModalOverlaysModule',
  }, {
    path: 'extra-components',
    loadChildren: './extra-components/extra-components.module#ExtraComponentsModule',
  }, {
    path: 'bootstrap',
    loadChildren: './bootstrap/bootstrap.module#BootstrapModule',
  }, {
    path: 'maps',
    loadChildren: './maps/maps.module#MapsModule',
  }, {
    path: 'charts',
    loadChildren: './charts/charts.module#ChartsModule',
  }, {
    path: 'editors',
    loadChildren: './editors/editors.module#EditorsModule',
  },{
    path: 'clientes',
    loadChildren: './clientes/tables.module#TablesModule',
  },{
    path: 'reportes',
    loadChildren: './reportes/forms.module#FormsModule',
  },
   {
    path: 'forms',
    loadChildren: './forms/forms.module#FormsModule',
  }, {
    path: 'novedades',
    loadChildren: './novedades/forms.module#FormsModule',
  }, {
    path: 'sueldos',
    loadChildren: './sueldos/forms.module#FormsModule',
  },
  {
    path: 'reporte',
    loadChildren: './reporte/forms.module#FormsModule',
  }, {
    path: 'tables',
    loadChildren: './tables/tables.module#TablesModule',
  }, {
    path: 'empleados',
    loadChildren: './empleados/tables.module#TablesModule',
  }, {
    path: 'categoria',
    loadChildren: './categoria/tables.module#TablesModule',
  }, {
    path: 'escala',
    loadChildren: './escala/tables.module#TablesModule',
  }, {
    path: 'rubros',
    loadChildren: './rubros/tables.module#TablesModule',
  }, {
    path: 'conceptos',
    loadChildren: './conceptos/tables.module#TablesModule',
  }, {
    path: 'miscellaneous',
    loadChildren: './miscellaneous/miscellaneous.module#MiscellaneousModule',
  }, {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  }, {
    path: '**',
    component: NotFoundComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
