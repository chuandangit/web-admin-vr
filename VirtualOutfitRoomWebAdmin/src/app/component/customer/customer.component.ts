<<<<<<< HEAD

import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import {DataTableDataSource } from '../other/data-table/data-table-datasource'
import { from } from 'rxjs';
=======
import { Component, OnInit } from '@angular/core';
>>>>>>> parent of c71294d... Merge branch 'master' of https://github.com/chitrung252/VirtualOutfitRoomWebAdmin

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
<<<<<<< HEAD
export class CustomerComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: DataTableDataSource;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'name'];

  ngAfterViewInit() {
    this.dataSource = new DataTableDataSource(this.paginator, this.sort);
=======
export class CustomerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
>>>>>>> parent of c71294d... Merge branch 'master' of https://github.com/chitrung252/VirtualOutfitRoomWebAdmin
  }

}
