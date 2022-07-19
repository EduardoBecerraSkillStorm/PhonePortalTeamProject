export class Plan {
    planID: number;
    planName: string;
    planPrice: number;
    userNameID: number;

    constructor (planID: number, planName: string, planPrice: number, userNameID: number) {
        this.planID = planID;
        this.planName = planName;
        this.planPrice = planPrice;
        this.userNameID = userNameID;
    }

}
