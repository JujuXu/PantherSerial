#include <Ultrasonic.h>

Ultrasonic ultrasonic(12,11); // 11 echo, 12 trig

int incomingByte = 0; // for incoming serial data

long time;


void setup() {
  Serial.begin(115200);

  pinMode(13, INPUT);
  pinMode(10, OUTPUT); //FOR Q
  pinMode(9, OUTPUT); //FOR S
  pinMode(8, OUTPUT); //FOR Z
  pinMode(7, OUTPUT); //FOR D
  pinMode(6, OUTPUT); //FOR clamp thighten
  pinMode(5, OUTPUT); //FOR clamp loosen
  pinMode(4, OUTPUT); //FOR ARM LEFT
  pinMode(3, OUTPUT); //FOR ARM RIGHT
  pinMode(2, OUTPUT); //FOR ARM FORWARD
  pinMode(14, OUTPUT); //FOR ARM BACKWARD
  pinMode(15, OUTPUT); // FOR wirst left
  pinMode(16, OUTPUT);  // FOR wirst right
  pinMode(17, OUTPUT); //FOR ARM HOME
  pinMode(18, OUTPUT); //FOR ARM UP
  pinMode(19, OUTPUT); //FOR ARM DOWN
}



void loop() {
  Serial.println(ultrasonic.read());

 if (Serial.available() > 0) {
    // read the incoming byte:
    incomingByte = Serial.read();

    if (incomingByte == 115){ //FOR Z
      digitalWrite(8,HIGH);
      delay(50);
      digitalWrite(8,LOW);
    }
    if (incomingByte == 113){ //FOR Q 
      digitalWrite(10,HIGH);
      delay(50);
      digitalWrite(10,LOW);
    }
    if (incomingByte == 122){ //FOR S
      digitalWrite(9,HIGH);
      delay(50);
      digitalWrite(9,LOW);
    }
    if (incomingByte == 100){ // FOR D
      digitalWrite(7,HIGH);
      delay(50);
      digitalWrite(7,LOW);
    }
    if (incomingByte == 97){ // a 
      digitalWrite(6,HIGH);
      delay(50);
      digitalWrite(6,LOW);
    }
    if (incomingByte == 101){ // e
      digitalWrite(5,HIGH);
      delay(50);
      digitalWrite(5,LOW);
    }
    if (incomingByte == 114){ // FOR 4
      digitalWrite(4,HIGH);
      delay(50);
      digitalWrite(4,LOW);
    }
    if (incomingByte == 102){ // FOR 6
      digitalWrite(3,HIGH);
      delay(50);
      digitalWrite(3,LOW);
    }
    if (incomingByte == 116){ // FOR ARM FORWARD
      digitalWrite(2,HIGH);
      delay(50);
      digitalWrite(2,LOW);
    }
    if (incomingByte == 103){ // FOR ARM BACKWARD
      digitalWrite(14,HIGH);
      delay(50);
      digitalWrite(14,LOW);
    }
    if (incomingByte == 121){ // FOR wirst left
      digitalWrite(15,HIGH);
      delay(50);
      digitalWrite(15,LOW);
    }
    if (incomingByte == 104){ // FOR wirst right
      digitalWrite(16,HIGH);
      delay(50);
      digitalWrite(16,LOW);
    }
    if (incomingByte == 109){ // FOR ARM HOME
      digitalWrite(17,HIGH);
      delay(50);
      digitalWrite(17,LOW);
    }
    if (incomingByte == 117){ // FOR ARM HOME
      digitalWrite(18,HIGH);
      delay(50);
      digitalWrite(18,LOW);
    }
    if (incomingByte == 106){ // FOR ARM HOME
      digitalWrite(19,HIGH);
      delay(50);
      digitalWrite(19,LOW);
    }
  }
}
