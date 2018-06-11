using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XML_Agent.Models;

namespace XML_Agent.IServices
{
    interface IPorukaService
    {
        void Insert(Poruka poruka);
        Poruka Get(string id);
        IQueryable<Poruka> GetAll();
        void Delete(string id);
        void Update(Poruka poruka);
    }
}
