import { Injectable } from '@angular/core';
import { Game } from '../model/games-model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http:HttpClient) { }
  baseUrl:string='http://localhost:3000/games';
  getGames(){
    return this.http.get<Game[]>(this.baseUrl);
  }
}
