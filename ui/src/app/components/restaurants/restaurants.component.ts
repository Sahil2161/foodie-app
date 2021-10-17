import { sharedStylesheetJitUrl } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import { FavouriteService } from 'src/app/services/favourite-service/favourite.service';
import { Favourite } from 'src/models/Favourite.model';
import { Restaurant } from 'src/models/Restaurant.model';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

  public emailId: string = window.localStorage.getItem('emailId')!;

  @Input('query') public query!: string | undefined;
  @Input('restaurants') public restaurants!: Restaurant[];

  constructor(private favService: FavouriteService) { }

  ngOnInit(): void {
  }

  addFavourite(event: any): void {
    console.log(event.target.id);

    let favRestaurant: Restaurant = this.restaurants.find(restaurant => restaurant.id === parseInt(event.target.id))!;    
    this.favService.addFavRestaurant(favRestaurant).subscribe(data => {
      alert('Restaurant added to favourites');
    }, error => {
      alert('Server error' + error);
    })
  }
}
