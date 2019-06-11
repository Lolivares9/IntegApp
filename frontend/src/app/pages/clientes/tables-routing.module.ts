import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TablesComponent } from './tables.component';
import { SmartTableComponent1 } from './administrar/smart-table1.component';
import { SmartTableComponent2 } from './facturacion/smart-table2.component';
// import { SmartTableComponent3 } from './cobranza/smart-table3.component';
import { SmartTableComponent4 } from './reportes/smart-table4.component';

const routes: Routes = [{
  path: '',
  component: TablesComponent,
  children: [
  {
    path: 'administrar',
    component: SmartTableComponent1,
  },
  {
    path: 'facturacion',
    component: SmartTableComponent2,
  },
  // {
  //   path: 'cobranza',
  //   component: SmartTableComponent3,
  // },
  {
    path: 'reportes',
    component: SmartTableComponent4,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TablesRoutingModule { }

export const routedComponents = [
  TablesComponent,
  SmartTableComponent1,
  SmartTableComponent2,
  // SmartTableComponent3,
  SmartTableComponent4
];
