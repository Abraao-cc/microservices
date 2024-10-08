import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { first, Observable, of, tap } from 'rxjs';
import { Ativo } from '../../persistence/model/ativo';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class AtivoService {
  private apiUrl!: string;
  private cache: Ativo[] = [];


  constructor(
    private http: HttpClient,
    private _sbar: MatSnackBar
  ) {
    this.apiUrl = 'http://localhost:8080/patrimony-service/ativos';
  }

  getAtivos(): Observable<Ativo[]> {
    return this.http.get<Ativo[]>(`${this.apiUrl}`);
  }

  addAtivo(record: Ativo): Observable<Ativo> {
    if (record._id !== null) {
      return this.update(record);
    }
    return this.save(record);
  }
  private update(record: Ativo) {
    return this.http.put<Ativo>(`${this.apiUrl}/ativo/edit`, record).pipe(first());
  }

   save(record: Ativo) : Observable<Ativo>{

    return this.http.post<Ativo>(this.apiUrl + '/ativo/add', record).pipe(first());
  }
  private getById(id: string) {
    return this.http.get<Ativo>(`${this.apiUrl}/ativo/${id}`).pipe(first());
  }
  delete(id: string) {
    return this.http.delete<Ativo>(`${this.apiUrl}/ativo/${id}`).pipe(first());
  }

  mensagem(msg: string): void {
    this._sbar.open(msg, '', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 5000

    });
  }

}
