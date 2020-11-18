import {Component, OnInit} from '@angular/core';
import {IscsService} from './service/iscs.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'iscs-fe';
  weather: any;
  smallestRangeWeather: any;

  team: any;
  smallestGoalDiff: any;

  showResult1: boolean = false;
  showResult2: boolean = false;

  constructor(private isscService: IscsService) {

  }

  ngOnInit(): void {
    this.isscService.getAllWeatherData().subscribe(result => {
      this.weather = result;
    });
    this.isscService.getAllFootballData().subscribe(result => {
      this.team = result;
    });

  }

  getSmallestGoalDiff(){
    this.isscService.getSmallestGoalDiff().subscribe(result => {
      this.smallestGoalDiff = result;
      this.showResult2 = true;
    });
  }

  getSmallestTempRange(){
    this.isscService.getSmallestTempRange().subscribe(result => {
      this.smallestRangeWeather = result;
      this.showResult1 = true;
    });

  }
}
