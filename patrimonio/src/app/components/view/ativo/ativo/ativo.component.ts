import { ChangeDetectionStrategy, Component, Inject, inject, model, OnInit, signal } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Ativo } from '../../../../persistence/model/ativo';
import { Category } from '../../../../persistence/model/category';
import { Localization } from '../../../../persistence/model/localization';
import { CategoryService } from '../../../../persistence/services/category.service';
import { LocalizationService } from '../../../../persistence/services/localization.service';
import { CommonModule, Location } from '@angular/common';
import { AtivoService } from '../../../../persistence/services/ativo.service';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatPseudoCheckboxModule, provideNativeDateAdapter } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { tap } from 'rxjs';

@Component({
  selector: 'app-ativo',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [

    CommonModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatDatepickerModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatPseudoCheckboxModule,
    MatRadioModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,

  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './ativo.component.html',
  styleUrl: './ativo.component.scss'
})
export class AtivoComponent implements OnInit {

  ativoForm!: FormGroup;
  ativo!: Ativo;
  category!: Category;
  localization!: Localization;

  ngDropdown = 1;

  categorys: Category[] = [];
  localizations: Localization[] = [];

  constructor(
    private categoryService: CategoryService,
    private localizationService: LocalizationService,
    private location: Location,
    private ativoService: AtivoService,
    private router: Router,
    private _fb: FormBuilder,
    private _dialogRef: MatDialogRef<AtivoComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: any,
  ) {
    this.ativoForm = this._fb.group({
      id: [''],
      name: ['', [Validators.required, Validators.minLength(5)]],
      serie: ['', [Validators.required, Validators.minLength(5)]],
      status: ['', [Validators.required]],
      price: ['', [Validators.required, Validators.minLength(3)]],
      datePay: [''],
      category: this._fb.group({
        id: [''],
        name: ['', [Validators.required, Validators.minLength(5)]],
      }),
      localization: this._fb.group({
        id: [''],
        name: ['', [Validators.required, Validators.minLength(5)]],
      })
    });
  }


  ngOnInit(): void {
    this.ativoForm.patchValue(this.data)
    this.getCategorys();
    this.getLocalizations();
  }

  onCreate(): void {
   
    if (this.ativoForm.value) {
      console.log(this.ativoForm.value);
      this.ativoService.create(this.ativoForm.value).subscribe(data => {
       
       
          console.log(this.ativoForm.value);
          this.ativoService.mensagem('save success!');
          this.router.navigate(['ativos']);
          this._dialogRef.close(true);
        });
    }

  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.name === o2.name && o1.id === o2.id;
  }
  getCategorys() {
    this.categoryService.findAll().subscribe(data => {
      this.categorys = data;
    }
    );
  }
  getLocalizations() {
    this.localizationService.findAll().subscribe(data => {
      this.localizations = data;
    }
    );
  }
  onCancel() {
    this.location.back();
    //this.funcionario;

  }


  resetAtivoForm() {
    this.ativoForm.reset();
  }

}
