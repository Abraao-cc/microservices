import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCommonModule, provideNativeDateAdapter } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Ativo } from '../../../../persistence/model/ativo';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';

import { AtivoService } from '../../../../persistence/services/ativo.service';
import { Router } from '@angular/router';
import { AtivoComponent } from '../ativo/ativo.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-ativos',
  standalone: true,
  providers: [
    provideNativeDateAdapter(),
    AtivoService
  ],
  imports: [

    CommonModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatCommonModule,
    MatFormFieldModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatToolbarModule,
    ReactiveFormsModule,



  ],
  templateUrl: './ativos.component.html',
  styleUrl: './ativos.component.scss'
})
export class AtivosComponent implements OnInit {

  ativos: Ativo[] = []
  displayedColumns: string[] = ['id', 'name', 'serie', 'status', 'price', 'datePay', 'category', 'localization', 'acoes'];


  dataSource!: MatTableDataSource<Ativo>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  constructor(
    private ativoService: AtivoService,
    private router: Router,
    private _dialog: MatDialog,
  ) { }


  ngOnInit(): void {
    this.getAtivos();
  }

  getAtivos() {
    this.ativoService.getAtivos().subscribe(data => {
      this.ativos = data;
      this.dataSource = new MatTableDataSource(this.ativos);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;

    }
    );
  }
  formAtivo() {

    const dialogRef = this._dialog.open(AtivoComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getAtivos();
        }
      },
    });
    this.router.navigate(["ativos"]);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  delete(id: string) {
    this.ativoService.delete(id).subscribe({
      next: (res) => {
        // this.ativoService.mensagem('');
        this.getAtivos();
      },
      error: console.log,
    });
  }

  editForm(data: Ativo) {

    const dialogRef = this._dialog.open(AtivoComponent, {
      data,

    });
    console.log(data)
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getAtivos();
        }
      },
    });
  }



}
