import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Funciones del Sistema',
    group: true,
  },
  {
    title: 'Clientes',
    icon: 'nb-person',
    children: [
      {
        title: 'Administrar',
        link: '/pages/clientes/administrar',
      },
      {
        title: 'Facturacion',
        link: '/pages/clientes/facturacion',
      },
      // {
      //   title: 'Cobranza',
      //   link: '/pages/clientes/cobranza',
      // },
      // {
      //   title: 'Reportes',
      //   link: '/pages/clientes/reportes',
      // },
    ],
  },
  {
    title: 'Empleados',
    icon: 'nb-person',
    children: [
      {
        title: 'Administrar',
        link: '/pages/empleados/smart-table',
      },
    ],
  },
  {
    title: 'Rubros',
    icon: 'nb-person',
    children: [
      {
        title: 'Administrar',
        link: '/pages/rubros/administrar',
      },
    ],
  },
  {
    title: 'Conceptos',
    icon: 'nb-person',
    children: [
      {
        title: 'Administrar',
        link: '/pages/conceptos/administrar',
      },
    ],
  },
  {
    title: 'Categorias',
    icon: 'nb-person',
    children: [
      {
        title: 'Administrar',
        link: '/pages/categoria/administrar',
      },
    ],
  },
  {
    title: 'Escala',
    icon: 'nb-person',
    children: [
      {
        title: 'Administrar',
        link: '/pages/escala/administrar',
      },
    ],
  },
  {
    title: 'Novedades',
    icon: 'nb-notifications',
    children: [
      {
        title: 'Cargar Novedades',
        link: '/pages/novedades/inputs',
      },
    ],
  },
  {
    title: 'Sueldos',
    icon: 'nb-compose',
    children: [
      {
        title: 'Liquidar sueldos',
        link: '/pages/sueldos/inputs',
      },
    ],
  },
  {
    title: 'Reportes',
    icon: 'nb-compose',
    children: [
      {
        title: 'Generar Reportes',
        link: '/pages/reporte/inputs',
      },
    ],
  },
  // {
  //   title: 'Reportes',
  //   icon: 'nb-compose',
  //   children: [
  //     {
  //       title: 'Generar Reportes',
  //       link: '/pages/reportes/inputs',
  //     },
  //   ],
  // },
];
