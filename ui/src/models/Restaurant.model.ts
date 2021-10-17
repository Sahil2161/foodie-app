import { Dish } from "./Dish.model";

export class Restaurant {
  id!: number;
  name!: string;
  city!: string;
  thumbnail!: string;
  category!: string;
  menu!: Dish[];
}