# InMemory Search Engine
Your organization has started a new tech blog with interesting tech stories
and you’re responsible for designing and implementing an in-memory search engine,
supporting the search functionality on the blog content.

--> Assume that search is case-insensitive. <br/>
--> It should be possible to create a dataset in the search engine. <br/>
--> It should be possible to insert documents into a given dataset. Each document is simply a piece of text.<br/>
--> It should be possible to search through documents for a search pattern in a given dataset.<br/>
--> A search pattern could have one or more words. When there are more words, all the words in the search pattern
should be present anywhere in the document to match, irrespective of their order. (Optional)<br/>
--> It should be possible to configure each dataset on how to order the search results.<br/>
    (Note for the interviewer:
    For example, one may want to configure a dataset to give higher rank to the documents 
    with a more number of occurrences of search term or latest) <br/>
--> It should be possible to print search results of a search.<br/>
--> It should be possible to print info of a given dataset - configuration and the document count.<br/>
--> It should be possible to delete a dataset. This should delete configuration of it.<br/>
