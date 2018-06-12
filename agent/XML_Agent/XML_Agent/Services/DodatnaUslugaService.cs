using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using XML_Agent.IServices;
using XML_Agent.Models;

namespace XML_Agent.Services
{
    public class DodatnaUslugaService : IDodatnaUslugaService
    {
        private readonly DodatnaUslugaUnitOfWork  dUnitOfwork;

        public DodatnaUslugaService()
        {
            dUnitOfwork = new DodatnaUslugaUnitOfWork();
        }
        public void Delete(string id)
        {
            dUnitOfwork.Usluga.Delete(d => d.Id, id);
        }

        public DodatnaUsluga Get(string id)
        {
            return dUnitOfwork.Usluga.Get(id);
        }

        public IQueryable<DodatnaUsluga> GetAll()
        {
            return dUnitOfwork.Usluga.GetAll();
        }

        public void Insert(DodatnaUsluga usluga)
        {
            dUnitOfwork.Usluga.Add(usluga);
        }

        public void Update(DodatnaUsluga usluga)
        {
            dUnitOfwork.Usluga.Update(d => d.Id, usluga.Id, usluga);
        }
    }
}