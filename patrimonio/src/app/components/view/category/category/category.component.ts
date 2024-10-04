import { ChangeDetectionStrategy, Component, Inject } from '@angular/core';
import { FormControl, Validators, FormBuilder, FormGroup, ReactiveFormsModule, FormsModule } from '@angular/forms';

import { Category } from '../../../../persistence/model/category';
import { CommonModule, Location } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../../../../persistence/services/category.service';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
    MatDialogModule,

  ],
  templateUrl: './category.component.html',
  styleUrl: './category.component.scss'
})
export class CategoryComponent {
  categoryForm!: FormGroup;
  category!: Category;

  constructor(
    private formBuilder: FormBuilder,
    private location: Location,
    private route: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService,
    @Inject(MAT_DIALOG_DATA)
    public data: any,
  ) {
    this.categoryForm = this.formBuilder.group({
      name: ['', Validators.minLength(3)],
    });
  }

  onSubmit() {
    console.log(this.categoryForm.value);
    this.categoryService.save(this.categoryForm.value).subscribe(data => this.gotoCategoryList());
  }
  gotoCategoryList() {
    this.router.navigate(['/categorys']);
  }
  onCancel() {
    this.location.back();
    //this.funcionario;

  }

}
