import { Component } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';

import { SmartTableData } from '../../../@core/data/smart-table';

@Component({
  selector: 'ngx-smart-table',
  templateUrl: './smart-table.component.html',
  styles: [`
    nb-card {
      transform: translate3d(0, 0, 0);
    }
  `],
})
export class SmartTableComponent {

  settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    columns: {
      cuil: {
        title: 'CUIL',
        type: 'number',
      },
      nombre: {
        title: 'Nombre',
        type: 'string',
      },
      apellido: {
        title: 'Apellido',
        type: 'string',
      },
      direccion: {
        title: 'Direccion',
        type: 'string',
      },
      email: {
        title: 'E-mail',
        type: 'string',
      },
      telefono: {
        title: 'Telefono',
        type: 'number',
      },
      tipoLiquidacion: {
        title: 'Tipo de Liquidacion',
        type: 'string',
      },
      convenio: {
        title: 'Convenio',
        type: 'string',
      },
      categoria: {
        title: 'Categoria',
        type: 'string',
      },
      salario: {
        title: 'Salario',
        type: 'number',
      },
      vacacionesDisponibles: {
        title: 'Vacaciones Disponibles',
        type: 'number',
      },
      diasdeEstudio: {
        title: 'Dias de Estudio',
        type: 'number',
      }
    },
  };

  source: LocalDataSource = new LocalDataSource();

  constructor(private service: SmartTableData) {
    const data = this.service.getData();
    this.source.load(data);
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Esta Seguro que desea eliminar el Empleado?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }
}
