package com.company;

public class Customer {

                    private String firstName;
                    private String lastName;
                    private String email;
                    private String phoneNumber;
                    private boolean rewardsMember;

                    private Address homeAddress;
                    private Address shippingAddress;
                    private RewardsCard rewardsCard;



            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public boolean isRewardsMember() {
                return rewardsMember;
            }

            public void setRewardsMember(boolean rewardsMember) {
                this.rewardsMember = rewardsMember;
            }

            public Address getHomeAddress() {
                return homeAddress;
            }

            public void setHomeAddress(Address homeAddress) {
                this.homeAddress = homeAddress;
            }

            public Address getShippingAddress() {
                return shippingAddress;
            }

            public void setShippingAddress(Address shippingAddress) {
                this.shippingAddress = shippingAddress;
            }

            public RewardsCard getRewardsCard() {
                return rewardsCard;
            }

            public void setRewardsCard(RewardsCard rewardsCard) {
                this.rewardsCard = rewardsCard;
            }
}
