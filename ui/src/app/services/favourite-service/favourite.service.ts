import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favourite } from 'src/models/Favourite.model';
import { Restaurant } from 'src/models/Restaurant.model';
import { UserService } from '../user-service/user.service';

@Injectable({
  providedIn: 'root'
})
export class FavouriteService {

  private BASE_URL: string = 'http://localhost:2323/favourites/';
  private emailId: string = window.localStorage.getItem('emailId')!;
  
  constructor(private http: HttpClient, private userService: UserService) { }
  
  addFavRestaurant(favRestaurant: Restaurant): Observable<Favourite> {
    let fav: Favourite = {
      emailId: this.userService.currentUser.emailId,
      restId: favRestaurant.id,
      name: favRestaurant.name,
      city: favRestaurant.city,
      thumbnail: favRestaurant.thumbnail
    };

    return this.http.post<Favourite>(this.BASE_URL, fav)
  }

  removeFavourite(favRestaurant: Favourite) {
    let params = new HttpParams()
                          .set('restId', favRestaurant.restId)
                          .set('emailId', favRestaurant.emailId);
    console.log('delete', params);
    
    return this.http.delete<Favourite>(this.BASE_URL, {params});
  }

  getFavourites(emailId: string): Observable<Favourite[]> {
    let params = new HttpParams().set('emailId', emailId);
    return this.http.get<Favourite[]>(this.BASE_URL, {params})
  }
}
