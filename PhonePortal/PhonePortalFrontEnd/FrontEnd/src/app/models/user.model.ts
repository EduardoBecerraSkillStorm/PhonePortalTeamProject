export class User {
    userNameID: number;    
    userName: string;
    plan: string;
    device: string;
    phoneNumber: number;

    constructor (userNameID: number, userName: string, plan: string, device: string, phoneNumber: number) {
        this.userNameID = userNameID;
        this.userName = userName;
        this.plan = plan;
        this. device = device;
        this.phoneNumber = phoneNumber;
    }
}
