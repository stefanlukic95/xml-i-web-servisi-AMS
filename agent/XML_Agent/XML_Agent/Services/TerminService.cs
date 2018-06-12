using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using XML_Agent.IServices;
using XML_Agent.Repository;
using XML_Agent.Models;

namespace XML_Agent.Services
{
    public class TerminService : ITerminService
    {

        private readonly TerminUnitOfWork tUnitOfwork;

        public TerminService()
        {
           tUnitOfwork = new TerminUnitOfWork();
        }
        public void Delete(string id)
        {
            tUnitOfwork.Termin.Delete(t => t.Id, id);
        }

        public Termin Get(string id)
        {
            return tUnitOfwork.Termin.Get(id);
        }

        public IQueryable<Termin> GetAll()
        {
            return tUnitOfwork.Termin.GetAll();
        }

        public void Insert(Termin termin)
        {
            tUnitOfwork.Termin.Add(termin);
        }

        public void Update(Termin termin)
        {
            tUnitOfwork.Termin.Update(t => t.Id, termin.Id, termin);
        }
    }
}