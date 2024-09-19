#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int maxHealth = health;
    int success = 0;

    for (int time = 1; time <= attacks.back()[0]; time++) {
        bool isAttacked = false;

        for (const auto& attack : attacks) {
            if (time == attack[0]) {
                isAttacked = true;
                health -= attack[1];
                if (health <= 0)
                    return -1;
                break;
            }
        }

        if (!isAttacked) {
            health += bandage[1];
            success++;
        }
        else {
            success = 0;
        }

        if (success == bandage[0]) {
            health += bandage[2];
            success = 0;
        }

        if (health > maxHealth)
            health = maxHealth;
    }

    return health > 0 ? health : -1;
}
