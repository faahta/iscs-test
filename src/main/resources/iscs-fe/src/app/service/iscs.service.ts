import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IscsService {

  constructor(private http: HttpClient) { }

  getAllWeatherData() {
    return this.http.get(environment.url + '/v1/weather/all');
  }

  getSmallestTempRange() {
    return this.http.get(environment.url + '/v1/weather');
  }


  getAllFootballData() {
    return this.http.get(environment.url + '/v1/football/all');
  }

  getSmallestGoalDiff() {
    return this.http.get(environment.url + '/v1/football');
  }
}
