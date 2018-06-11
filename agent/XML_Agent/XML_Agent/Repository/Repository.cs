using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using MongoDB.Driver;
using XML_Agent.Models;
using MongoDB.Driver.Builders;
using System.Linq.Expressions;

namespace XML_Agent.Repository
{
    public class Repository<T> where T : class
    {
        
        private MongoDatabase database;
        private string tableName;
        private MongoCollection<T> collection;

        public Repository(MongoDatabase db, string tblName)
        {
            database = db;
            tableName = tblName;
            collection = database.GetCollection<T>(tblName);
        }

        public T Get(string id)
        {
            return collection.FindOneById(id);
        }

        public IQueryable<T> GetAll()
        {
            MongoCursor<T> cursor = collection.FindAll();
            return cursor.AsQueryable<T>();
        }

        public void Add(T entity)
        {
            collection.Insert(entity);
        }

        public void Delete(Expression<Func<T, string>> queryExpression, string id)
        {
            var query = Query<T>.EQ(queryExpression, id);
            collection.Remove(query);
        }

        public void Update(Expression<Func<T, string>> queryExpression, string id, T entity)
        {
            var query = Query<T>.EQ(queryExpression, id);
            collection.Update(query, Update<T>.Replace(entity));
        }

      
    }
}