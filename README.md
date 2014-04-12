SEL
===

#Simple Entity Language

The Simple Entity Language is an abstract data structure definition language.

## Sample usage patterns
- Help create sustainable public APIs by making the exposed domain model design technology independent
- Facilitate DTO mapping in cross-platform communications
- Facilitate event serialisation/transport independence for event based architectures
- Make the world a better place by getting rid of crufty schema languages.

##Goals
- Be able to define very simple objects with simple relationships.
- Have a language that is natural and trivial for developpers to use
- Define structures that do not depend on specific implementation languages/platforms
- Provide tooling, both for editing schema files, and for generating target languages implementations
- Make it possible for software designers to do Model Driven Development without the horrible pain of working with UML
- Make it as easy as possible to add target languages/platforms, a new schema output format should take a few hours to create and debug.

## Sample domain model using all features

    TODO

## Downloads


#FIQ (Frequent Imaginary Questions, and angry answers)

> Why the hell have another entity schema language when you have protocol buffers, Json schema, xsd, ASN-1, annotated yaml, avro, etc ...

All existing entity schema languages are highly linked to a serialization implementation, pure abstract data definition languages are rare, proprietary, and graphic.

> Exactly! Why not use the very mature UML class diagram and associated tooling that have great enterprise acceptance.

- XMI is heavy, not that mature, and not that interoperable in practice
- Graphical languages are low productivity and very low maintainability, their perceived value is in the low amount of training necessary to read them but real life experience shows that "graphic" has nothing to do with "intuitive"
- My goal is to help developers, not to help IBM sell software and consultants sell methodology and diagrams.
- People who love UML are mostly people who would never touch anything that can ever go in production if their life depended on it.
	
> The tooling is in java, I really want to develop on my iPad !

I'm really sorry you don’t have a real open computer;
A fully functional, but not as user friendly, JavaScript version is in the works.

> The tooling is in java, I hate java, do it in Haskell/Ruby/Perl/C#/Scheme !

Fuck you too, the [EBNF](https://github.com/neuneu2k/SEL/blob/master/JetbrainsPlugin/src/fr/assoba/open/sel/jetbrains/sel.bnf) is here, have fun.

> What the heck is that custom JavaScript templating language, we have better ways to generate code !

Yes, I know about stringtemplate, fully typed scala templates, Razor, etc... JavaScript is universally known, hard to master but trivial to use for simple templating, and anyways if the browser based version for (platform slaves)/(whining java haters) is to work, JavaScript is the name of the game.

> Why are you so rude?

I should not have to do that thing, we have had reason and technology to do this for decades, it's not hard, and it’s dumb work that should have been done before I was even born.

> Wait, you are right, this is trivial, why does it not exist already, made by a nicer guy ?

I have no idea, I suspect that most people who start to define a data modeling language cannot resist creating a full IDL with inheritance, a transport and lifetime model and rewrite the nth version of CORBA...

