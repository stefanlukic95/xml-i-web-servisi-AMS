using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XML_Agent.Models;

namespace XML_Agent.IServices
{
    interface IkometariService
    {
        void Insert(Komentari komentari);
        Komentari Get(string id);
        IQueryable<Komentari> GetAll();
        void Delete(string id);
        void Update(Komentari komentari);
    }
}
