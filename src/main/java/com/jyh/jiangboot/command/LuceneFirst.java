package com.jyh.jiangboot.command;

import java.io.File;
import java.io.IOException;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * @author jiangyuhong
 * @date 2020/9/21 14:48
 */
public class LuceneFirst {





	private void save() throws IOException {
		Directory directory = FSDirectory.open(new File("/Users/luv/Desktop/index/dataindex").toPath());

		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new IKAnalyzer());
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

//		IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig());

		for (int i = 0; i < 10; i ++) {

			Field field1 = new TextField("name", "名称：" + i, Field.Store.YES);
			Field field2 = new TextField("content", "姜宇鸿,啦啦啦啦 啊啊啊 哈哈哈哈" + i + "lalalala", Field.Store.YES);

			Document document = new Document();
			document.add(field1);
			document.add(field2);

			indexWriter.addDocument(document);
		}
		indexWriter.close();
	}


	private void search() throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File("/Users/luv/Desktop/index/dataindex").toPath());

		IndexReader indexReader = DirectoryReader.open(directory);

		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		//域
		String[] fields = { "phoneType", "name", "category", "price" };
		QueryParser queryParser = new MultiFieldQueryParser(fields, new IKAnalyzer());
		Query query = queryParser.parse("组织的喜报");


//		QueryParser queryParser = new QueryParser("title", new IKAnalyzer());
//		Query query = queryParser.parse("组织的喜报");


//		Query query = new TermQuery(new Term("title", "组织"));
//		Query query = new TermQuery(new Term("title", "喜报"));
//		Query query = new TermQuery(new Term("id", "285"));


		TopDocs topDocs = indexSearcher.search(query, 10);

		System.out.println("查询总记录数:" + topDocs.totalHits);

		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc doc : scoreDocs) {
			int docId = doc.doc;

			Document document = indexSearcher.doc(docId);
			System.out.println(document.get("id"));
			System.out.println(document.get("title"));
			System.out.println(document.get("content"));

		}

		indexReader.close();


	}



	public static void main(String[] args) throws IOException, ParseException {
		LuceneFirst luceneFirst = new LuceneFirst();
		luceneFirst.save();

		System.out.println(1);

		luceneFirst.search();

		System.out.println(2);

	}




}
