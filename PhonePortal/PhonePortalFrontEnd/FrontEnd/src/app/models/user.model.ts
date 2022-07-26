export class User {
    device_name_1: string;
    device_name_2: string;
    device_name_3: string;
    device_name_4: string;
    monthly_price: number;
    name: string;
    pass_word: string;
    phone_number_1: string;
    phone_number_2: string;
    phone_number_3: string;
    phone_number_4: string;
    plan_name: string;
    user_id: number;


    constructor (    
        device_name_1: string,
        device_name_2: string,
        device_name_3: string,
        device_name_4: string,
        monthly_price: number,
        name: string,
        pass_word: string,
        phone_number_1: string,
        phone_number_2: string,
        phone_number_3: string,
        phone_number_4: string,
        plan_name: string,
        user_id: number) {
        
            this.device_name_1 = device_name_1;
            this.device_name_2 = device_name_2;
            this.device_name_3 = device_name_3;
            this.device_name_4 = device_name_4;
            this.monthly_price = monthly_price;
            this.name = name;
            this.pass_word = pass_word;
            this.phone_number_1 = phone_number_1;
            this.phone_number_2 = phone_number_2;
            this.phone_number_3 = phone_number_3;
            this.phone_number_4 = phone_number_4;
            this.plan_name =plan_name;
            this.user_id = user_id;
    }
}