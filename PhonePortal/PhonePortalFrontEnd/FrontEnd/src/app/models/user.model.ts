export class User {
    user_id: number;    
    user_name: string;
    pass_word: string;
    token?: string;


    constructor (user_id: number, user_name: string, pass_word: string) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass_word = pass_word;
    }
}
