import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { LocalizationService } from '../../../../persistence/services/localization.service';
import { Localization } from '../../../../persistence/model/localization';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule, Location } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';




@Component({
  selector: 'app-localization',
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
    HttpClientModule
  ],
  templateUrl: './localization.component.html',
  styleUrl: './localization.component.scss'
})
export class LocalizationComponent {
  localizationForm!: FormGroup;
  localization!: Localization;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private localizationService: LocalizationService,
    private formBuider: FormBuilder,
    private location: Location,
  ) {
    this.localizationForm = this.formBuider.group({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    });


  }

  onSubmit() {
    if (this.localizationForm.valid) {
      this.localizationService.save(this.localizationForm.value).subscribe(this.getLocalizations);
    }
  }
  getLocalizations() {
    this.router.navigate(['localizations'])
  }

  onCancel() {
    this.location.back();

  }


  resetLocalizationForm() {
    this.localizationForm.reset();
  }
}
