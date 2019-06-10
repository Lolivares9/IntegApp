import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TablesComponent } from './tables.component';
import { SmartTableComponent } from './administrar/smart-table.component';

const routes: Routes = [{
  path: '',
  component: TablesComponent,
  children: [
  {
    path: 'administrar',
    component: SmartTableComponent,
  },
  {
    path: 'facturacion',
    component: SmartTableComponent,
  },
  {
    path: 'cobranza',
    component: SmartTableComponent,
  },
  {
    path: 'reportes',
    component: SmartTableComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TablesRoutingModule { }

export const routedComponents = [
  TablesComponent,
  SmartTableComponent,
];
