import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/models/Restaurant.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  // baseurl for json server
  private BASE_URL: string = "http://localhost:2323/restaurants/"

  constructor(private http: HttpClient) { }

  getAllRestaurants(): Observable<Restaurant[]> {
    console.log('get all rest');
    return this.http.get<Restaurant[]>(this.BASE_URL);
  }

  getRestaurantsByName(name: string): Observable<Restaurant[]> {
    let params = new HttpParams().set('name', name);
    console.log("search for name: ", name);
    
    return this.http.get<Restaurant[]>(this.BASE_URL + "get/", {params});
  }

  getRestaurantsByCity(city: string): Observable<Restaurant[]> {
    console.log('city:', city);
    
    let params = new HttpParams().set('city', city);
    return this.http.get<Restaurant[]>(this.BASE_URL + "get/", {params} );
  }

  getRestaurantsByCategory(category: string): Observable<Restaurant[]> {
    let params = new HttpParams().set('category', category);
    return this.http.get<Restaurant[]>(this.BASE_URL + "get/", {params});
  }
}
