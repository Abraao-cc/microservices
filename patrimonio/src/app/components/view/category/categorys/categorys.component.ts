import { HttpClientModule } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table'
import { CommonModule } from '@angular/common';
import { Category } from '../../../../persistence/model/category';
import { CategoryService } from '../../../../persistence/services/category.service';
import { Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCommonModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CategoryComponent } from '../category/category.component';
import { MatDialog } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
@Component({
  selector: 'app-categorys',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
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
    MatButtonModule

  ],
  templateUrl: './categorys.component.html',
  styleUrl: './categorys.component.scss'
})
export class CategorysComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name','acoes'];
  categorys: Category[] = [];
  clickedRows = new Set<Category>();
  dataSource = new MatTableDataSource<Category>(this.categorys);

  constructor(
    private categoryService: CategoryService,
    private router: Router,
    private _dialog: MatDialog,
  ) {
  }
  ngOnInit(): void {
    this.getCategorys();
  }


  formCategory() {

    const dialogRef = this._dialog.open(CategoryComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCategorys();
        }
      },
    });
    this.router.navigate(["categorys"]);
  }

  getCategorys() {
    this.categoryService.findAll().subscribe(data => {
      this.categorys = data;
      this.dataSource = new MatTableDataSource<Category>(this.categorys);
    });
  }
  categoryDetail(id: string) {
    this.router.navigate(['category-details', id]);
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  update(data: Category) {
    this.router.navigate(['update', data]);
  }
  delete(id: string) {
    this.categoryService.deleteData(id).subscribe(data => {
      console.log(data);
      this.getCategorys();
    })
  }
  editForm(data: Category) {
    console.log(data)
    const dialogRef = this._dialog.open(CategoryComponent, {
      data,

    }
    );

    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCategorys();
        }
      },
    });
  }

}