import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Passage} from "./passage";
import {environment} from "../environments/environment";

const QUARKUS_PASSAGES_PATH = `${environment.QUARKUS_API_URL}/passages`;
const SPRING_PASSAGES_PATH = `${environment.SPRING_API_URL}/passages`;

@Injectable()
export class PassagesService {
  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Passage[]> {
    return this.http.get<Passage[]>(SPRING_PASSAGES_PATH);
  }

  save(passage: Passage): Observable<Passage> {
    return this.http.post<Passage>(SPRING_PASSAGES_PATH, passage);
  }

  deleteBy(id: number): Observable<void> {
    return this.http.delete<void>(`${QUARKUS_PASSAGES_PATH}/${id}`);
  }
}
