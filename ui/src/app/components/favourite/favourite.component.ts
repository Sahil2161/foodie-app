import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FavouriteService } from 'src/app/services/favourite-service/favourite.service';
import { Favourite } from 'src/models/Favourite.model';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit, OnChanges {

  public favourites!: Favourite[];
  public emailId: string = window.localStorage.getItem('emailId')!;
  

  constructor(private favService: FavouriteService) {
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    this.favService.getFavourites(this.emailId).subscribe(data => {
      this.favourites = data;
    }, error => {
      alert(error);
    })
  }

  ngOnInit(): void {
    this.getAllFavourites();
  }

  getAllFavourites() {
    this.favService.getFavourites(this.emailId).subscribe(data => {
      this.favourites = data;
    }, error => {
      alert(error);
    })
  }

  removeFavourite(event: any) {
    let favRestaurant: Favourite = this.favourites.find(restaurant => (
      restaurant.name === event.target.name &&
      restaurant.restId === parseInt(event.target.id)
      )
    )!;    
    this.favService.removeFavourite(favRestaurant).subscribe(data => {
      alert('Restaurant removed from favourites');
    }, error => {
      alert('Server error in removing favourite' + error);
    })
  }

}
