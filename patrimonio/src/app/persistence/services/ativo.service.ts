import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, first, Observable, of, tap, throwError } from 'rxjs';
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
    return this.http.get<Ativo[]>(`${this.apiUrl}`).pipe(
      catchError(error => {
        console.error('Error fetching JSON data:', error);
        return throwError(() => new Error('Something went wrong; please try again later.'));
      })
    );
  }


  addAtivo(data: Ativo): Observable<Ativo> {
    if (data._id != null) {
      return this.update(data);
    }
    return this.save(data);
  }
  private update(data: Ativo) {
    return this.http.put<Ativo>(`${this.apiUrl}/ativo/edit`, data).pipe(first());
  }

  private save(data: Ativo) {

    return this.http.post<Ativo>(`${this.apiUrl}/ativo/add`, data).pipe(
      catchError(error => {
        console.error('Error adding ativo:', error);
        return throwError(() => new Error('Failed to add ativo.'));
      })
    );
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
