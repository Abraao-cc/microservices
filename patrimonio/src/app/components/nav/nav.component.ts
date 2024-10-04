import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { ActivatedRoute, Router, RouterLink, RouterOutlet } from '@angular/router';
import { HeaderComponent } from "../header/header.component";
import { AtivosComponent } from "../view/ativo/ativos/ativos.component";
import { CategoryComponent } from "../view/category/category/category.component";
import { CategorysComponent } from "../view/category/categorys/categorys.component";
import { LocalizationsComponent } from "../view/localization/localizations/localizations.component";
import { HttpClient } from '@angular/common/http';
import { AtivoComponent } from '../view/ativo/ativo/ativo.component';
import { MatDialogModule } from '@angular/material/dialog';


@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [
    MatSidenavModule,
    MatButtonModule,
    MatListModule,
    MatIconModule,
    MatDialogModule,
    RouterOutlet,
    RouterLink,
    HeaderComponent,
    AtivoComponent,
    AtivosComponent,
    CategoryComponent,
    CategorysComponent,
    LocalizationsComponent,
  ],
  providers: [HttpClient],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.scss'
})
export class NavComponent implements OnInit {
  //route: ActivatedRoute = inject(ActivatedRoute);
  //housingLocationId = -1;
  constructor(private router: Router) {
    //this.housingLocationId = Number(this.route.snapshot.params['id']);
  }
  ngOnInit(): void {
    this.router.navigate(['home']);
  }

}
