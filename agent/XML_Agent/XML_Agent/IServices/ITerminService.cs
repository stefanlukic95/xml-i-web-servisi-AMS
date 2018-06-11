using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XML_Agent.Models;

namespace XML_Agent.IServices
{
    interface ITerminService
    {
        void Insert(Termin termin);
        Termin Get(string id);
        IQueryable<Termin> GetAll();
        void Delete(string id);
        void Update(Termin termin);
    }
}
