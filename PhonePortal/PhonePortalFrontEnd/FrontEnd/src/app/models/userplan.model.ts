export class UserPlan {
    userName: string;
    plan: string;
    device: string;
    phoneNumber: number;

    constructor (userName: string, plan: string, device: string, phoneNumber: number) {
        this.userName = userName;
        this.plan = plan;
        this. device = device;
        this.phoneNumber = phoneNumber;
    }
}
