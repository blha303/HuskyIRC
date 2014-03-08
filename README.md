HuskyIRC [![Build Status](http://ci.drtshock.net/view/Huskehhh/job/HuskBot/badge/icon)](http://ci.drtshock.net/view/Huskehhh/job/HuskBot/)
========

Private IRC Bot for Husky. :)

## Usage

!c \<query\> -- Gives \<query\> a cookie!  
!pizza \<query\> -- Gives \<query\> a pizza!  
!slap \<query\> -- Slaps \<query\>!  
!slay \<query\> -- Slays \<query\>!  
!eat \<query\> -- Eats \<query\>!  
!hf \<query\> -- Hi-fives \<query\>!  
\o -- Responds with o/  
o/ -- Responds with \o  
HuskBot: Is Smithey someone's bitch? -- Responds with
> Once upon a there was a person named Smithey, He went around saying he would finish stuff, but in actual fact he didn't.  
One day the almighty Zachoz learned that incentives would make him become his bitch.  
And to this day he is still the bitch of the almighty Zachoz!  
The End!  

HuskBot: Do you like OresomeBot? -- Responds with
> He's okay I guess...But it wouldn't bother me if it had a bug and was taken out of action.

!roll \<number\> -- Picks a random number between 0 and \<number\>.  
!gc -- Responds with information about how much memory its using.  
!ci -- Responds with  
> http://ci.drtshock.com/view/Huskehhh/  
Kindly provided by drtshock and blha303! :D

!channels -- Responds with a list of all the connected channels.  
\*!join \<channel\> -- Attempts to join \<channel\>.  
\*!part \<channel\> -- Leaves \<channel\>.  
\*!op \<user\> -- Attempts to op \<user\>.  
\*!deop \<user\> -- Attempts to deop \<user\>.  
\*!voice \<user\> -- Attempts to voice \<user\>.  
\*!devoice \<user\> -- Attempts to devoice \<user\>.  
\*!ban \<user\> -- Attempts to ban \<user\>.  
\*!unban \<user\> -- Attempts to unban \<user\>.  
\*!mute \<user\> -- Attempts to mute \<user\>.  
\*!unmute \<user\> -- Attempts to umute \<user\>.  
\*\*!update [repo] -- Attempts to update the bot. (Never works! :P)  
!version -- Responds bot and online versions.  
!check \<ip\> -- Responds with host name of \<ip\>.  
!ping \<ip\> -- Responds with the results of the ping.
!stats \<BattlePlayer\> -- Responds with the statistics of 'BattlePlayer'
!remind \<Number\>[s|m|h] \<User|Channel\> \<Message\> -- Set a reminder to be sent after 'o' so many minutes

\* - Bot admins only.  
\*\* - Husk only.

## Compiling

HuskyIRC uses [Apache Maven 3](http://maven.apache.org/) to compile!

To compile HuskyIRC, simply install [Apache Maven](http://maven.apache.org/), and run:
```mvn -f pom.xml clean install -P shade```
or
```mvn clean install -U```


## Contributing

Would you like to contribute to HuskyIRC?
Do you have an awesome feature you'd like implemented?

If you'd like a feature added, please [open a new issue](https://github.com/Huskehhh/HuskyIRC/issues/new).
Otherwise, check out [CONTRIBUTING.md](https://github.com/Huskehhh/HuskyIRC/blob/master/CONTRIBUTING.md) to find out how to add your code!