How to Contribute
=================

This guide briefly explains how to fork HuskyIRC and submit a pull request containing your code through GitHub.
For more information about GitHub and how you can use it, take a look at [GitHub Help!](https://help.github.com)

## Forking HuskyIRC

To edit HuskyIRC's code, you must first fork the HuskyIRC repository.
To do this, you will need a [GitHub Account](https://github.com/join).

Forking a repository copies the repository's code under you account name, so you can edit and commit changes to your own repository.

To create a new fork of HuskyIRC, navigate to [HuskyIRC's GitHub Page](https://github.com/Huskehhh/HuskyIRC) and press the 'fork' button.

![Fork](http://i.imgur.com/1h9kOUS.png)

Once you've forked the repository, GitHub should redirect you to your 'fork' of HuskyIRC.

![YourFork](http://i.imgur.com/9U1QTHZ.png)

From there, you have two ways to add code to your repository.

You can either clone your fork and edit it from your desktop,

![Clone](http://i.imgur.com/1ktHecK.png)

which requires [GitHub for Windows](https://windows.github.com) or [GitHub for Mac](https://mac.github.com).

or, you can edit your code using your browser.

![BrowserEdit](http://i.imgur.com/FBhP9yw.png)

![BrowserEdit2](http://i.imgur.com/rccpXzA.png)

## Updating the Version

Once you've made your edits to the code, open the VERSION file in the main directory (If you're editing the code using your browser, you'll need to make a commit before doing this).
Increment the last number in the version file by one.

For example, if the version is ```2.3.6```, it would be changed to ```2.3.7```.

![Version](http://i.imgur.com/e0neanC.png)

## Committing Code

Once you've made changes to your code, you then need to commit your code.

If you've made changes to your code in the browser, there should be a commit dialog at the bottom of your page.

![WebCommit](http://i.imgur.com/UPnKlt9.png)

Simply type a summary of what you've edited, and press 'commit changes'.
Remember to use Future Tense language in the description of your commit.

For example:
> "Added a command"

is very bad, however
> "Add !hello command"

is good.

If you've made changes to the code from your desktop using the "Clone in Desktop" button,
you'll need to commit your changes using [GitHub for Windows](https://windows.github.com) or [GitHub for Mac](https://mac.github.com).
To do this, open up [GitHub for Windows](https://windows.github.com) or [GitHub for Mac](https://mac.github.com) and navigate to the HuskyIRC repository.

![DesktopRepository](http://i.imgur.com/XiYRrXp.png)

Write a short summary of the changes you've made and press 'commit'.
Remember to use Future Tense language in the description of your commit.

For example:
> "Added a command"

is very bad, however
> "Add !hello command"

is good.

Once you've pressed 'commit', you'll need to press the 'Sync' button in order to push your changes to the [GitHub Site](https://github.com).

![Sync](http://i.imgur.com/pHQWE00.png)

## Creating a Pull Request

In order for the changes that you made to be added to the [HuskyIRC main repository](https://github.com/Huskehhh/HuskyIRC), you will need to create a Pull Request.

To create a pull request, simply navigate to your fork of the HuskyIRC repository. In this case, this will be https://github.com/psgs/HuskyIRC.
You can navigate to your fork of the repository by replacing 'psgs' by your GitHub username.

From there, click on the 'Pull Request' icon

![PullIcon](http://i.imgur.com/UKx5JbV.png)

and click 'New Pull Request'

![NewPull](http://i.imgur.com/slzTyGS.png)

![ConfirmPull](http://i.imgur.com/455vpvk.png)

Now fill in a brief summary of the changes you made (this summary can be the same as the summary you used to create your commit) and click "Send Pull Request".

![SendPull](http://i.imgur.com/IvxRbtQ.png)

Once your pull request is accepted, you'll be notified by [GitHub](https://github.com), and your pull request page should look similar to this.

![MergedPull](http://i.imgur.com/75OgCR5.png)

## Checklist

Ready to commit/submit your code? Perform the checklist below:

1. Have all tabs been replaced by four spaces? Are indentations 4-space wide?
2. Does the code work? Have you tested it?
3. Have you formatted your code correctly?

Example
-------

This is **GOOD:**

```java
    if (var.func(param1, param2)) {
        // do things
    }
```

This is **EXTREMELY BAD:**

```java
    if(var.func( param1, param2 ))
    {
        // do things
    }