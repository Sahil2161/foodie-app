import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { FavouriteService } from 'src/app/services/favourite-service/favourite.service';
import { RestaurantService } from 'src/app/services/restaurant-service/restaurant.service';
import { Restaurant } from 'src/models/Restaurant.model';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public userNotSearched!: boolean;
  public searchBy!: string;
  public query!: string;
  public restaurants!: Restaurant[];

  public pic: any;

  constructor(private service: RestaurantService, private router: Router) {
    this.userNotSearched = true;
  }

  ngOnInit(): void {
    this.pic = localStorage.pic;
    // recommended
    this.service.getAllRestaurants().subscribe(data => {
      console.log(data);
      this.restaurants = data;
    }, error => {
      alert(error);
    })
  }

  onSearch(searchForm: NgForm) {
    console.log(`SearchBy: ${this.searchBy} & Query: ${this.query}`);

    if (this.searchBy && this.query) {
      this.userNotSearched = false;
      this.query = this.query.toLowerCase();
    }

    if (this.searchBy === 'city') {
      console.log('here');

      this.service.getRestaurantsByCity(this.query).subscribe(data => {
        if (data) {
          this.restaurants = data;
        }
      },
        error => {
          if (error) {
            alert("There was some error fetching the data");
          }
        })
    }

    if (this.searchBy === 'name') {
      this.service.getRestaurantsByName(this.query).subscribe(data => {
        if (data) {
          this.restaurants = data;
        }
      },
        error => {
          if (error) {
            alert("There was some error fetching the data");
          }
        })
    }
  }

  searchByCategory(event: any) {
    let category = event.target.value;
    if (this.searchBy === category) {
      this.service.getRestaurantsByCategory(category).subscribe(data => {
          this.restaurants = data;
        
      },
        error => {
          if (error) {
            alert("There was some error fetcing the data");
          }
        }
      )
    }
  }

  onLogout() {
    localStorage.removeItem('emailId');
    this.router.navigate(['login']);
  }
}
