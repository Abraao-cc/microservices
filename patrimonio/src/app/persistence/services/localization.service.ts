import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, of, tap, Observable } from 'rxjs';
import { Localization } from '../../persistence/model/localization';
import { LocalizationPage, } from '../../persistence/model/localization-page';

@Injectable({
  providedIn: 'root'
})
export class LocalizationService {

  private readonly apiUrl!: string;

  private cache: Localization[] = [];

  constructor(private http: HttpClient) {
    this.apiUrl = 'http://localhost:8080/patrimony-service';
  }

 


   findAll(): Observable<Localization[]> {
    return this.http.get<Localization[]>(this.apiUrl+'/localizations').pipe(first());
  }

  loadById(id: string) {
    if (this.cache.length > 0) {
      const record = this.cache.find(localization => `${localization.id}` === `${id}`);
      return record != null ? of(record) : this.getById(id);
    }
    return this.getById(id);
  }

  private getById(id: string) {
    return this.http.get<Localization>(`${this.apiUrl}/${id}`).pipe(first());
  }

  save(record: Partial<Localization>) {
    if (record.id) {
      return this.update(record);
    }
    return this.create(record);
  }

  private update(record: Partial<Localization>) {
    return this.http.put<Localization>(`${this.apiUrl}/${record.id}`, record).pipe(first());
  }

  private create(record: Partial<Localization>) {
    return this.http.post<Localization>(this.apiUrl, record).pipe(first());
  }

  delete(id: string) {
    return this.http.delete<Localization>(`${this.apiUrl}/${id}`).pipe(first());
  }
}
