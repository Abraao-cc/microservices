import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from '@angular/core';
import { Localization } from '../../../../persistence/model/localization';
import { LocalizationService } from '../../../../persistence/services/localization.service';
import { MatCommonModule } from '@angular/material/core';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { LocalizationComponent } from '../localization/localization.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-localizations',
  standalone: true,
  imports: [
    CommonModule,
    MatCommonModule,
    HttpClientModule,
    MatTableModule,
    MatIconModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatToolbarModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './localizations.component.html',
  styleUrl: './localizations.component.scss'
})
export class LocalizationsComponent implements OnInit {
  localizations: Localization[] = [];
  displayedColumns: string[] = ['id', 'name', 'acoes'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private localizationService: LocalizationService,
    private router: Router,
    private _dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.getLocalizations();
  }


  formLocalization() {

    const dialogRef = this._dialog.open(LocalizationComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getLocalizations();
        }
      },
    });
    this.router.navigate(["localizations"]);
  }


  getLocalizations() {
    this.localizationService.findAll().subscribe(data => {
      this.localizations = data;
      this.dataSource = new MatTableDataSource(this.localizations);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }



  delete(id: string) {
    this.localizationService.delete(id).subscribe({
      next: (res) => {
        //this.localizationService.mensagem('');
        this.getLocalizations();
      },
      error: console.log,
    });
  }

  editForm(data: Localization) {
    console.log(data)
    const dialogRef = this._dialog.open(LocalizationComponent, {
      data,

    }
    );

    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getLocalizations();
        }
      },
    });
  }

}
