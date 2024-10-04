import { Category } from "./category";
import { Localization } from "./localization";

export interface Ativo {
  id?: any,
  name: string,
  serie: string,
  status: string,
  price: number,
  datePay: any,
  category: Category,
  localization: Localization
}
